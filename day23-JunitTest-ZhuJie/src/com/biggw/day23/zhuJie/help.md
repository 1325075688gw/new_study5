### 注解(1.5版本之后)
- 注释:用文字描述,给程序员看的
- 注解:用代码描述,给计算机看的

- 作用:
    1. 编写代码:通过代码里面的注解生成文档,文档注释是/**,然后我们去cmd输入,javadoc .java, 就可以生成doc文档
    2. 代码分析:通过代码里面标识的注解对代码进行分析,[使用反射]
    3. 编译检查:通过代码里面表示的注解让编译器能够实现基本的编译检查[Override]
    
    
- JDK中预定义[内置]的一些注解
    - Override:检查是否重写[写错了有安全检查]
    - Deprecated:标注已过时,不建议使用[但是仍可以使用]
    - SuppressWarings("all"):压制警告
        - 一般传递参数[all]
- 自定义注解
    - 格式:元注解
    - public @interface 注解名称{}

    - 本质:注解本质上就是一个接口,该接口默认继承Annotation接口
        - 我们可以进行反编译
        >       javac xxx.java --->先javac编译,这时候编译文件应该带上.java--->这时候会生成.class文件
        >       javap xxx.clas --->反编译,也就是重新生成.java文件
        >       javap xxx
    - 属性:接口中可以定义的成员方法[抽象方法]
        - 这里面的属性可以有默认值 int age() default 23
    - 属性[成员方法]的类型:
        >       4类8型
        >       String
        >       enum[枚举]
        >       注解
        >       上面类型的数组
        >       没有void类型,没有类类型
    - 定义了属性,在注解的时候赋值,用逗号分割.
    - value属性,可以不用写value

- 元注解[描述注解的注解]
    - @Target:用于描述注解能够作用的位置
        - ElementType取值:
        >       TYPE:可以作用于类上
        >       METHOD:可以作用于方法上
        >       FIELED:可以作用于成员变量上
    - @Retention:用于描述注解被保留的位置[比如类,函数,变量]                   
    - @Documentd:用于描述注解是否被抽取到api文档中[生成doc文档,先javadoc xxx.java]
    - @Inherited:用于描述该注解是否可以被继承(自动继承)

- 在程序中使用注解
    - 获取注解定义的位置的对象(Class,Method,Field)
        >         // 获取注解的实现类对象
        >         reflect annotation = mainClass.getAnnotation(reflect.class);
        ```java
        /*

        public class reflectImpl implements reflect{
            public String className(){
                // 将上面的注解属性写进去
                return "com.biggw.day23.ZhuJiePractice.Person";
            }

            public String methodName(){
                //将上面的注解属性填进去
                return "eat";
            }

        }

        // 多态
        reflect obj = new reflectImpl();
         */


        // 调用上面的className()方法,返回"com.biggw.day23.ZhuJiePractice.Person"
        String className = annotation.className();

        // 调用上面的methodName()方法,返回"eat"
        String methodName = annotation.methodName();
      ```
- 注解给谁用:
    - 编译器
    - 给解析程序用,就像我们写一个check注解,我们另外一个程序使用该注解

