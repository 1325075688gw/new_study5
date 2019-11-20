# 今日内容
	1. web相关概念回顾
	2. web服务器软件：Tomcat
	3. Servlet入门学习 :sever applet运行在服务器端的小程序




## web相关概念回顾
	1. 软件架构
		1. C/S：客户端/服务器端
		2. B/S：浏览器/服务器端
	
	2. 资源分类
		1. 静态资源：所有用户访问后，得到的结果都是一样的，称为静态资源.静态资源可以直接被浏览器解析
			* 如： html,css,JavaScript
		2. 动态资源:每个用户访问相同资源后，得到的结果可能不一样。称为动态资源。动态资源被访问后，需要先转换为静态资源，在返回给浏览器,然后浏览器解析
			* 如：servlet/jsp,php,asp....


	3. 网络通信三要素
		1. IP：电子设备(计算机)在网络中的唯一标识。
		2. 端口：应用程序在计算机中的唯一标识。 0~65536
		3. 传输协议：规定了数据传输的规则
			1. 基础协议：
				1. tcp:安全协议，三次握手。 速度稍慢
				2. udp：不安全协议。 速度快


## web服务器软件：
	* 服务器：安装了服务器软件的计算机
	* 服务器软件：接收用户的请求，处理请求，做出响应
	* web服务器软件：接收用户的请求，处理请求，做出响应。
		* 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目
		* web容器


	* 常见的java相关的web服务器软件：
		* webLogic：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
		* webSphere：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
		* JBOSS：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
		* Tomcat：Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的。


	* JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范
	
	// tomcat启动失败(黑窗口一闪而过),我们需要检查JAVA_HOME是否配置正确,因为tomcat是用Java写的,所以运行需要JDK的支持,外面想要访问JDK,我们就需要将JDK的bin目录提出来,放到JAVA_HOME里面去,然后有软件的配置文件用到了JDK,我们就可以直接写上path=JAVA_HOME/bin即可
	
	
	* Tomcat：web服务器软件
		1. 下载：http://tomcat.apache.org/
		2. 安装：解压压缩包即可。
			* 注意：安装目录建议不要有中文和空格
		3. 卸载：删除目录就行了
		4. 启动：
			* bin/startup.bat ,双击运行该文件即可
			* 访问：浏览器输入：http://localhost:8080 回车访问自己
							  http://别人的ip:8080 访问别人
			
			* 可能遇到的问题：
				1. 黑窗口一闪而过：
					* 原因： 没有正确配置JAVA_HOME环境变量
					* 解决方案：正确配置JAVA_HOME环境变量
	
				2. 启动报错：
					1. 暴力：找到占用的端口号，并且找到对应的进程，杀死该进程
						* netstat -ano
					2. 温柔：修改自身的端口号(可以去log文件中查看出错原因)
						* conf/server.xml
						* <Connector port="8888" protocol="HTTP/1.1"
			               connectionTimeout="20000"
			               redirectPort="8445" />
						* 一般会将tomcat的默认端口号修改为80。80端口号是http协议的默认端口号。
							* 好处：在访问时，就不用输入端口号,只输入域名(localhost),或者ip地址(127.0.0.1)
							
		5. 关闭：
			1. 正常关闭：
				* bin/shutdown.bat
				* ctrl+c
			2. 强制关闭：
				* 点击启动窗口的×
		6. 配置:
			* 部署项目的方式：
				项目:hello.html存放在test_web文件夹中
			
				1. 直接将项目放到webapps目录下即可。
					1. 虚拟目录:test_web
					* 将test_web文件夹放到webapps里面去
						* 浏览器输入: http://localhost:8080/test_web/hello.html,则可以访问
					* 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。
						* 打成war包的方式:
							1. 可以下载专业工具,打包
							2. 直接压缩,然后修改后缀名为war
						* war包会自动解/压缩(如果删除war包,则项目自动删除,添加war包,则项目自动添加)
						* 浏览器访问: http://localhost:8080/test_web_war/test_web_war/hello.html
	
				2. 配置conf/server.xml文件
					1. 虚拟目录:path:/here
					浏览器访问: http://localhost:8080/here/hello.html

					在<Host>标签体中配置
					<Context/> 是自闭合标签
					<Context docBase="D:\code\Java\test_web_conf" path="/here" />
					* docBase:项目存放的路径
					* path：虚拟目录(别名或者引用)
					
					弥补缺点: 这样我们就可以不用把项目拷贝到webapps里面去了(弥补第一种配置方式的缺点)
	
				3. 在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写
					1. 虚拟目录(别名或者引用)：xml文件的名称  // 我们在<Context> 里面就不用写path虚拟路径
					<Context docBase="D:\hello" />					
					弥补缺点: 
						1.第二种方式修改的事server.xml文件,关系到整个tomcat服务器的运行,所以一旦弄坏就不好,所以不推荐第二种方式
						2.第二种方式,我们每次修改了server.xml文件中的内容,我们都需要重新启动tomcat服务器.而第三种方式,属于热启动,我们如果不想使用hello项目,我们直接修改aaa.xml,修改为任意其它名称,建议修改为aaa.xml_bak,bak(备份文件的意思).同时,我们不用重启tomcat服务器,也能继续访问.
						
						
			   额外知识:bak文件
			   		bak是备份文件，为文件格式扩展名。直接打是打不开的，一般来讲 .bak文件可以通过直接重命名把bak替换成该文件的格式就可以恢复此文件并且正常打开了，不需要其他软件辅助打开。
			   		备份文件的作用：很多软件都将创建备份文件设置为软件的默认配置，尤其是很多的编程、绘图、设计软件，这样的好处是当源文件不小心被删掉或是由于软件自身的BUG而导致自动退出时，还可以在备份文件的基础上继续编辑，否则前面的汗水就只能付诸东流了，从而减少了不少的误操作带来的损失。
			
			* 静态项目和动态项目：
				* 目录结构
					* java动态项目的目录结构：
						-- 项目的根目录
							-- WEB-INF目录：
								-- web.xml：web项目的核心配置文件
								-- classes目录：放置字节码文件的目录
								-- lib目录：放置依赖的jar包


			* 将Tomcat集成到IDEA中，并且创建JavaEE的项目，部署项目。





## Servlet：  server applet
	* 概念：运行在服务器端的小程序
		* Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
		* 将来我们自定义一个类，实现Servlet接口，复写方法。就能被tomcat识别到. 


	* 快速入门：
		1. 创建JavaEE项目
		2. 定义一个类，实现Servlet接口
			* public class ServletDemo1 implements Servlet
		3. 实现接口中的抽象方法
		4. 配置Servlet
			 在web.xml中的<web-app里面>配置：
		    <!--配置Servlet -->
		    <servlet>
		        <servlet-name>demo1(相当于给下面的ServletDemo01取一个别名)</servlet-name>
		        <servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>
		    </servlet>
		
		    <servlet-mapping>
		        <servlet-name>demo1</servlet-name>
		        <url-pattern>/demo1(资源访问路径)</url-pattern>
		    </servlet-mapping>
	
	* 执行原理：
		1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
		2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
		3. 如果有，则在找到对应的<servlet-class>全类名
		4. tomcat会将字节码文件加载进内存，并且创建其对象
		5. 调用其方法Service
	
	* Servlet中的生命周期方法：
		1. 被创建：执行init方法，只执行一次
			* Servlet什么时候被创建？
				* 默认情况下，第一次被访问时，Servlet被创建
				* 可以配置执行Servlet的创建时机。
					* 在<servlet>标签下配置
						1. 第一次被访问时，创建
	                		* <load-on-startup>的值为负数
			            2. 在服务器启动时，创建
			                * <load-on-startup>的值为0或正整数


			* Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的【多个用户请求来了，每一个请求来开启一个线程】
				* 多个用户同时访问时，如果定义了成员变量,比如tickets = 100,卖票,则多个用户过来,可能存在线程安全问题。
				        我们虽然可以通过加锁,来解决线程安全问题,但是性能影响太大.不推荐.
				* 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值.
				        推荐将变量定义到方法里面,这样每一次变量都加载到栈内存(方法里面的变量是不共享的),用完了就释放.
	
		2. 提供服务：执行service方法，执行多次
			* 每次访问Servlet时，Service方法都会被调用一次。
		3. 被销毁：执行destroy方法，只执行一次
			* Servlet被销毁时执行。服务器关闭时，Servlet被销毁
			* 只有服务器正常关闭时，才会执行destroy方法。
			* destroy方法在Servlet被销毁之前执行，一般用于释放资源
	
	* Servlet3.0：
		* 好处：
			* 支持注解配置。可以不需要web.xml了。
	
		* 步骤：
			1. 创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
			2. 定义一个类，实现Servlet接口
			3. 复写方法
			4. 在类上使用@WebServlet注解，进行配置
				* @WebServlet("资源路径")


				@Target({ElementType.TYPE})
				@Retention(RetentionPolicy.RUNTIME)
				@Documented
				public @interface WebServlet {
				    String name() default "";//相当于<Servlet-name>
				
				    String[] value() default {};//代表urlPatterns()属性配置
				
				    String[] urlPatterns() default {};//相当于<url-pattern>
				
				    int loadOnStartup() default -1;//相当于<load-on-startup>
				
				    WebInitParam[] initParams() default {};
				
				    boolean asyncSupported() default false;
				
				    String smallIcon() default "";
				
				    String largeIcon() default "";
				
				    String description() default "";
				
				    String displayName() default "";
				}



## IDEA与tomcat的相关配置
	1. IDEA会为每一个tomcat部署的项目单独建立一份配置文件
		* 查看控制台的log：Using CATALINA_BASE:   "C:\Users\fqy\.IntelliJIdea2018.1\system\tomcat\_itcast"
	
	2. 工作空间项目    和     tomcat部署的web项目【out目录下面的东西】
		* tomcat真正访问的是“tomcat部署的web项目”，"tomcat部署的web项目"对应着"工作空间项目" 的web目录下的所有资源
		* WEB-INF目录下的资源不能被浏览器直接访问。
	3. 断点调试：使用"小虫子"启动 dubug 启动