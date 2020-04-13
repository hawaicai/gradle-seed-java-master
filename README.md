## gradle-seed

### 使用`gradle init`初始化项目

* `gradle init`
* Select type of project to generate:
    ```
        1: basic
        2: application
        3: library
        4: Gradle plugin
    Enter selection (default: basic) [1..4] 3
    ```
* Select implementation language:
    ```
        1: C++
        2: Groovy
        3: Java
        4: Kotlin
        5: Scala
        6: Swift
    Enter selection (default: Java) [1..6] 3
    ```
* Select build script DSL:
    ```
        1: Groovy
        2: Kotlin
    Enter selection (default: Groovy) [1..2] 1
    ```
* Select test framework:
    ```
        1: JUnit 4
        2: TestNG
        3: Spock
        4: JUnit Jupiter
    Enter selection (default: JUnit 4) [1..4]
    ```
* `Project name (default: demo): gradle-seed`
* `Source package (default: demo): com.jiker.length` 

### 仓库配置

```groovy
repositories {
    maven {
        url 'https://maven.aliyun.com/repository/central'
    }
    jcenter()
}
```       

### 添加依赖

1. 程序正常运行请在gradle脚本中添加如下依赖：
    * com.google.guava:guava:28.2-jre
    * com.google.inject:guice:4.2.3
    * junit:junit:4.13
    * org.assertj:assertj-core:3.9.1
    * org.mockito:mockito-core:3.3.3    
    
### 考试通过的标准

1. 能够成功执行`gradle build`。    
2. 能够正确配置gradle：
    * 包含gradle wrapper。
    * 在执行`gradle build`之后能够生成jar包。
3. 能够正确配置gradle checkstyle插件：
    * checkstyle只检查src/main/java下的代码。
    * 在执行`gradle build`之后能够执行`checkstyleMain`。
    * 在执行`gradle build`之后能够生成checkstyle html报告。
4. 能够正确配置gradle jacoco插件：
    * 能够正确配置gradle jacoco的exclude。
    * 在执行`gradle build`之后能够执行`jacocoTestCoverageVerification`和`jacocoTestReport`。
    * 在执行`gradle build`之后能够生成jacoco html和xml报告，并且报告中的测试覆盖率为100%。 