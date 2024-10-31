# mall

## 创建每个微服务模块

注意导入的内容


**聚合服务（在pom.xml文件中）**

```xml
    <groupId>com.guigu.mall</groupId>
    <artifactId>mall</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>mall</name>
    <description>聚合服务</description>
    <packaging>pom</packaging>

    <modules>
        <module>mall-coupon</module>
        <module>mall-member</module>
        <module>mall-order</module>
        <module>mall-product</module>
        <module>mall-ware</module>
    </modules>

```

聚合主要是添加了modules和packaging



**修改gitignore**

在git页面，标记是红色的表示没有纳入"要提交文件"的；绿色表示**新创建文件**（已纳入git）但未提交的；蓝色表示**修改**但暂未提交的

`**/mvnw` : 表示任意路径下的这个文件
