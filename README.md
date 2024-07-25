# Spring Boot 后端通用模板

**@author wsy**

### 特点

> 集成Spring Boot 2.7.6、Spring Web、MySQL 驱动、Mybatis-Plus 3.5.7、Hutool 5.8.26、knife4j 4.4.0

**省去繁琐选择依赖的过程，基本做到应有既有，开箱即用！**

### 功能

1. AOP

2. 统一返回类型

   **成功**

   ```json
   {
       "code":0,
       "msg":"ok",
       "data": {
           "数据1":"数据1"
       }
   }
   ```

   **失败**

   ```json
   {
       "code":"数字类型错误码",
       "msg":"错误信息",
       "data": null
   }
   ```

3. 全局异常处理

4. knife4j接口文档