###  观察者模式: 
观察者模式,又称为发布订阅模式,用于建立一种对象与对象之间的依赖关系,  
一个对象发生改变时将会自动通知其他对象,其他对象作出相应的反应,  
在观察者模式中,发生改变的对象称为观察目标,而被通知的对象称为观察者,一个观察者目标可以对应多个观察者; 

### 观察者模式应用场景 
观察者模式为实现对象之间的联动提供了一套完整的解决方案,凡是涉及一对一或一对多的对象交互的场景都可以使用观察者模式,观察者模式广泛应用于各种GUI处理的实现,基于事件的XML解析技术(如SAX2)以及WEB事件处理;如
Spring中事件监听机制就是根据观察者模式实现的.