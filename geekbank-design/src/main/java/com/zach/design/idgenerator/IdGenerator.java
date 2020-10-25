package com.zach.design.idgenerator;

/**
 * Created by Zach
 * Date :2020/10/25 18:16
 * Description :
 * Version :1.0
 */
public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
