# 项目初始化

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
</br>
屎黄色（很丑的黄色）的文件表示git ignore的文件


`**/mvnw` : 表示任意路径下的这个文件

（PS: .gitignore 中添加的路径只会对新添加的文件或未被跟踪的文件生效。对已提交的文件不起作用。）


## 数据库设计

所有表之间不建立外键！外键关联消费性能


## 后台管理系统

https://github.com/renrenio/renren-fast

https://github.com/renrenio/renren-fast-vue

https://github.com/renrenio/renren-generator

TODO 问题：导入renren-fast后maven的pom.xml有报错。

https://blog.csdn.net/loulanyue_/article/details/102524955
项目需要的依赖本地没找到，但build内没有主动去远程镜像里寻找，所以需要第一次更新依赖要手动操作

报错解决汇总：
https://blog.csdn.net/qq_36765625/article/details/123622815

parent.relativePath报错：
https://zhuanlan.zhihu.com/p/453547775





## p16 运行renren后台管理 疯狂报错（数据库Access denied for user）

报错信息：

```
2024-10-31 22:04:48.177 ERROR 74692 --- [eate-1510129635] com.alibaba.druid.pool.DruidDataSource   : create connection SQLException, url: jdbc:mysql://120.26.83.211:3456/gulimall_admin?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai, errorCode 1045, state 28000

java.sql.SQLException: Access denied for user 'root'@'211.161.157.209' (using password: YES)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:836)
	at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:456)
	at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:246)
	at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:197)
	at com.alibaba.druid.filter.FilterChainImpl.connection_connect(FilterChainImpl.java:156)
	at com.alibaba.druid.filter.FilterAdapter.connection_connect(FilterAdapter.java:786)
	at com.alibaba.druid.filter.FilterChainImpl.connection_connect(FilterChainImpl.java:150)
	at com.alibaba.druid.filter.stat.StatFilter.connection_connect(StatFilter.java:218)
	at com.alibaba.druid.filter.FilterChainImpl.connection_connect(FilterChainImpl.java:150)
	at com.alibaba.druid.pool.DruidAbstractDataSource.createPhysicalConnection(DruidAbstractDataSource.java:1572)
	at com.alibaba.druid.pool.DruidAbstractDataSource.createPhysicalConnection(DruidAbstractDataSource.java:1636)
	at com.alibaba.druid.pool.DruidDataSource$CreateConnectionThread.run(DruidDataSource.java:2550)

```

**<font color=red>解决问题：权限设置有问题，新创建了一个别的用户，就好使了</font>**



很奇怪的一个问题，反正我是不理解，也没有在网上找到合理的解释。

运行renren后，会循环报错。从报错的内容中可以看到，主要的问题在于java.sql.SQLException: Access denied for user 'root'@'211.161.157.209' (using password: YES)。

这里报错的这个ip我不太清楚是什么ip，这个不是我要连接的数据库的ip。（可能是我本地的ip？）

排除了以下几个问题：

* 账号密码肯定是正确的
* `select host, user from mysql.user` 确保root用户可以远程登录。而且navicat、idea database都可以顺利连接数据库。不是数据库远程连接权限的问题。

在尝试更换数据库后，发现：

* 使用本地数据库，可以顺利连上
* 使用远程数据库，阿里ECS和虚拟机数据库，都连不上，报错内容相同，都是Access denied

目前并没有找到解决bug的方法。先使用本地搭建renren后台管理的数据库。

**另外不知道分布式项目中是否会出现类似的数据库访问失败情况**







## 管理系统前端

安装Nodejs

```shell
brew install node

node --version
# npm是前端的包管理工具，类似maven
npm --version

npm config set registry https://registry.npmmirror.com

# 在项目中执行命令（想当于让maven下载依赖）
npm install
# package.json 文件中记录了依赖和版本
```



前端报错：

```
npm ERR! code 1
npm ERR! path /Users/jmjin/Developer/frontend/renren-fast-vue/node_modules/chromedriver
npm ERR! command failed
npm ERR! command sh -c node install.js
npm ERR! Only Mac 64 bits supported.

npm ERR! A complete log of this run can be found in: /Users/jmjin/.npm/_logs/2024-10-31T15_47_30_511Z-debug-0.log
```

原因似乎是arm64芯片兼容性问题。

在package.json中，发现chromedriver的版本是` "chromedriver": "2.27.2"`，但是[官网](https://www.npmjs.com/package/chromedriver?activeTab=versions)中查看到的版本都已经100多了。我很怀疑这两个到底是不是一个东西。



运行`npm run dev`是用来启动前端项目的。

```shell
npm run dev

npm install node-sass --unsafe-perm --save-dev
```

启动的时候如果报错还可能需要执行下面这行指令。然后他又提示我了一些python相关的报错（可能是找不到python版本，这和我本地的python环境有关）。

```shell
alias python=/usr/bin/python3
export PYTHON=/Users/jmjin/opt/anaconda3/bin/python
```

我在.zshrc添加这两条代码并编译后，再执行`npm run dev`就莫名其妙的跑起来了。



🔴 保留的问题：chromedriver





## Git pull失败

失败描述：每次git pull提交时，会要求登录github。但是登录github后，依旧无法pull成功。

```shell
git remote -v
# origin  https://github.com/JasperJin01/mall.git (fetch)
# origin  https://github.com/JasperJin01/mall.git (push)
```

输出表示远程仓库 URL 使用的是 **HTTPS**，而不是 **SSH**。

使用SSH方式进行认证和操作，需要将远程仓库 URL 设置为 SSH 格式。

```shell
# 将当前的 HTTPS URL 更改为 SSH URL
git remote set-url origin git@github.com:JasperJin01/mall.git

# 再次确认是否更新成功：
git remote -v
# origin  git@github.com:JasperJin01/mall.git (fetch)
# origin  git@github.com:JasperJin01/mall.git (push)
```







## generator 快速生成CRUD代码



生成的代码有很多依赖

创建mall-common，用来放一些公用的包，让每个微服务都依赖它



在product项目的pom.xml添加一个依赖，依赖common项目



### 测试项目报错

```java
package com.guigu.mall.product;

import com.guigu.mall.product.entity.BrandEntity;
import com.guigu.mall.product.service.BrandService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// FIXME 这里必须有 RunWith
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    // NOTE 这个test导包要注意一下，`import org.junit.Test;`, 不要导错了
    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setLogo("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }
}
```



```
java.lang.IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
```



<font color=red>代码是没有问题的！错误是版本问题。在pom.xml(mall-product)中设置的Springboot的版本，最开始为3就会报错，设为2就不会报错！</font>





生成过程中遇到的问题：

* Junit版本和对应的import @Test包不对。可能是sb项目默认sb3的原因吧，Tests模版中的@Test是`org.junit.jupiter.api.Test`。一定要改成`org.junit.Test`。
* 还有一些版本的问题，例如在pom.xml中springboot的版本，java的版本都改正确，避免出问题。（之前的报错bug就是配置文件中版本为sb3导致的）
* 🔴 半保留的问题。在UndoLogEntity中rollbackInfo类型由*Longblob*改成了byte[]，同时添加了@Lob注解，引入了import jakarta.persistence.Lob;包，引入了jakarta.persistence-api 依赖。
* `<dependencyManagement>` 中的依赖不会自动引入，只有在子模块中显式添加 `<dependency>` 引用时，才会生效。
* 想把junit依赖放到common里面，但是发现mybatisplus会报错。最终发现是因为自己的mybatisplus没有声明版本。（这是一种语法错误，在maven clean的时候都会报错）





# 注册服务与远程调用

## 安装Nacos

Nacos用来做注册中心和配置中心

<font color=red>TODO：老师找的nacos的文档是从哪里找到的啊？好多年之前的链接了现在好像都没有了，有空查找一下！</font>

首先要在pom.xml中导入相关依赖

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    <version>2.1.0.RELEASE</version>
</dependency>
```



在Ubuntu系统安装nacos server

```shell
java -version
# 没有java，按照命令提示安装java（我安装的是jdk8）

# 下载nacos
wget https://github.com/alibaba/nacos/releases/download/2.2.0/nacos-server-2.2.0.zip

# 解压nacos
unzip nacos-server-2.2.0.zip
cd nacos/bin
# readlink: missing operand
# Try 'readlink --help' for more information.
# dirname: missing operand
# Try 'dirname --help' for more information.
# ERROR: Please set the JAVA_HOME variable in your environment, We need java(x64)! jdk8 or later is better! !!

sh startup.sh 
###### 最后启动失败了，不知道
```



于是使用docker

```shell
docker pull nacos/nacos-server

docker run -d --name nacos -p 8848:8848 -e MODE=standalone nacos/nacos-server
```





## 将一个模块服务注册到Nacos-server

又是一个debug了很长时间的问题。实际上还是版本不匹配的问题。

简单说来，springboot必须选择等于或高于2.6的版本，要不然会抛出各种错误。







# 配置中心





# API 网关


git提交测试