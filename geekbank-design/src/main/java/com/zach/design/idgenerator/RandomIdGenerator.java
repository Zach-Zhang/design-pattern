package com.zach.design.idgenerator;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by Zach
 * Date :2020/10/25 18:23
 * Description :
 * Version :1.0
 */
public class RandomIdGenerator implements LogTraceIdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);


    @Override
    public String generate() throws IdGenerationFailureException {
        String subStrOfHostName = null;
        try {
            subStrOfHostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("generate random string failed");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", subStrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private String getLastfieldOfHostName() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        if (StringUtils.isEmpty(hostName)) {
            throw new UnknownHostException("hostName is empty");
        }
        return getLastSubstrSplittedByDot(hostName);
    }

    private String getLastSubstrSplittedByDot(String hostName) {
        if (StringUtils.isEmpty(hostName)) {
            throw new IllegalArgumentException("hostName is empty");
        }
        String[] tokens = hostName.split("\\.");
        String subStrOfHostName = tokens[tokens.length - 1];
        return subStrOfHostName;
    }

    private String generateRandomAlphameric(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length is zero");
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

    public static void main(String[] args) {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        try {
            String generate = idGenerator.generate();
            System.out.println(generate);
        } catch (IdGenerationFailureException e) {
            logger.error(e.getMessage());
        }
    }
}
