### 测试分类
1.黑盒测试:不需要人写代码,我们直接给输入值,看程序能否输出给定的期望值

2.白盒测试:需要写代码,关注程序具体的执行流程

    Junit就属于白盒测试的一种
    
    
#### 步骤:
- 定义一个测试类(测试用例)
    - 建议:
        - 包名:xxx.xxx.xxx.test               com.biggw.test
        - 测试类名:被测试的类名+后缀Test        CalculatorTest
        - 一般情况下待测试包应该和测试包,同级目录
- 定义测试方法(可以独立运行)
    - 建议:
        - 测试方法名:test前缀+函数名            testAdd()
        - 返回值:void
        - 参数列表:空参
- 给方法加上注解@Test,这样我们就可以独立运行测试方法
- 导入junit依赖环境    

#### 判定结果
- 绿色:成功
- 红色:失败
- 一般我们不直接看输出,来判断测试是否通过,我们通过断言来进行操作:Assert.assertEquals(2[期望结果],result[真实结果])
- 未添加注解,则该方法不会执行

#### 补充
- @Before:修饰的方法会在测试方法之前被自动执行
- @After:修饰的方法会在测试方法之后被自动执行

### 反射:框架设计的灵魂
- 框架:半成品软件.我们可以在框架的基础上进行软件开发,简化编码
- 反射:将类的各个组成部分封装为其他对象,供我们单独提取出类的各部分信息.这就是反射机制
    - 好处:
        1. 可以在程序运行过程中,操作这些对象
        2. 可以解耦,提高程序的可扩展性
- 获取Class对象的方式
    1. Class.forName("全类名"):将字节码文件加载到内存中,返回Class对象的引用
        > 多用于配置文件.我们可以将类名等其它信息的定义在存储到配置文件中,读取我们启动系统时候,就去读取配置文件,然后读取的时候就加载类
    2. 类名.class:通过字面量进行获取,这时候只会加载Class对象,不会初始化Class对象静态字段
        > 多用于参数的传递                                                
    3. 对象.getClass():getClass()方法在Object类中定义
        > 多用于对象获取字节码的操作 
    - 结论:
        - 同一字节码文件(*.class)在一次程序运行过程中,只会被加载一次,不论通过哪一种方式获取的Class对象都是同一个
        
- Class对象功能:
    - 获取功能:
        1. 获取成员变量们
            - Field[] getFields() 获取public修饰的成员变量
            - Field getField(String name)
            
            - Field[] getDeclaredFields() 获取私有等成员变量(忽略访问权限修饰符)
            - Field getDeclaredField(String name)
        2. 获取构造方法们
            - Constructor<?>[] getConstructors()
            - Constructor<T> getConstructor(Class<?>...parameterTypes)
            
            - Constructor<?>[] getDeclaredConstructors()
            - Constructor<T> getDeclaredConstructor(Class<?>...parameterTypes)
        3. 获取成员方法们
            - Method[] getMethods()
            - Method getMethod(String name,Class<?>...parameterTypes)
            
            - Method[] getDeclaredMethods()
            - Method getDeclaredMethod(String name,Class<?>...parameterTypes)
        4. 获取类名
            - String getName()  
            
- Field:成员变量
    - 操作
        1. 设置值
            - void set(Object obj, Object value)
                >     Person person = new Person();
                >     Class pClass = person.getClass();                                                   
                >     Field d = pClass.getDeclaredField("d");
                >     d.setAccessible(true);
                >     // 忽略访问权限修饰符的安全检查
                >     Object objD = d.get(person);
                >     System.out.println("objD = " + objD);                      
                           
        2. 获取值
            - get(Object obj)
        3. 忽略访问权限修饰符的安全检查
            - setAccessible(true)   暴力反射:成员变量,成员方法,都有
                    
- Constructor:构造器
    - 操作
        1. 获取值
            >         Person person = new Person();
            >          Class pClass = person.getClass();
            >  
            >          Constructor constructor = pClass.getConstructor(String.class, String.class);
            >          Object obj1 = constructor.newInstance("小强", "小黑");
            >          System.out.println("obj1 = " + obj1);
            >  
            >          // 构造无参的对象
            >          Constructor constructor1 = pClass.getConstructor();
            >          Object obj2 = constructor1.newInstance();
            >          System.out.println("obj2 = " + obj2);
            >  
            >          // 构造无参的对象(推荐使用这种方法)
            >          Object obj3 = pClass.newInstance();
            >          System.out.println("obj3 = " + obj3);    

- Method:方法
    - 操作
        - 设置获取值
            >         Person person = new Person();
            >         Class pClass = person.getClass();
            > 
            > 
            >         // 获取指定名称的方法
            >         Method eat = pClass.getMethod("eat",String.class);
            >         Method run = pClass.getMethod("run");
            > 
            >         // 执行方法名
            >         eat.invoke(person,"小强");
            >         run.invoke(person);
            > 
            >         // 获取所有public 方法
            >         // 这儿会把Object类里面的方法,打印出来,因为基继承
            >         Method[] methods = pClass.getMethods();
            > 
            >         for (Method method : methods) {
            >             System.out.println("method = " + method);
            >             // 获取方法名的间写
            >             String name = method.getName();
            >             System.out.println("name = " + name);
            >         }
 
 - Class:类名
    - 操作
        - 设置获取
            >          Person person = new Person();
            >          Class pClass = person.getClass();
            >  
            >          // 获取类名
            >          String className = pClass.getName();
            >          System.out.println("className = " + className);                   
            
> class是获取当前类的class对象,getClassLoader()是获取当前的类加载器，什么是类加载器？简单点说,就是用来加载java类的,类加载器就是负责把class文件加载进内存中,并创建一个java.lang.Class类的一个实例，也就是class对象,并且每个类的类加载器都不相同.getResourceAsStream(path)是用来获取资源的,因为这是ClassLoader（类加载器）了获取资源,而类加载器默认是从classPath下获取资源的，因为这下面有class文件.所以这段代码总的意思是通过类加载器在classPath目录下获取资源.并且是以流的形式。我们知道在Java中所有的类都是通过加载器加载到虚拟机中的，而且类加载器之间存在父子关系，就是子知道父，父不知道子，这样不同的子加载的类型之间是无法访问的（虽然它们都被放在方法区中），所以在这里通过当前类的加载器来加载资源也就是保证是和类类型同一个加载器加载的。

> 资源文件(xml,properties...)；