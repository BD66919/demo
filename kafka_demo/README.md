# kafka_demo

下载地址：http://kafka.apache.org/downloads

要下载Binary downloads这个类型，不要下载源文件，这种方便使用。下载后，解压放在D:\bigdata目录下。

进入kafka配置文件所在目录，D:\bigdata\kafka_2.11-0.9.0.1\config

编辑文件"server.properties"，找到并编辑：

 log.dirs=/tmp/kafka-logs  to  log.dirs=D:/bigdata/kafka_2.11-0.9.0.1/kafka-logs 或者 D:\\bigdata\\kafka_2.11-0.9.0.1\\kafka-logs

同样注意：路径要么是"/"分割，要么是转义字符"\\"，这样会生成正确的路径(层级，子目录)。错误路径情况可自行尝试，文件夹名为这种形式：bigdatakafka_2.11-0.9.0.1kafka-logs

在server.properties文件中，zookeeper.connect=localhost:2181代表kafka所连接的zookeeper所在的服务器IP以及端口，可根据需要更改。本文在同一台机器上使用，故不用修改。

kafka会按照默认配置，在9092端口上运行，并连接zookeeper的默认端口2181。

advertised.listeners=PLAINTEXT://10.210.165.125:9092#消费者订阅，使用默认的localhost的话只能在本机消费



运行kafka
提示：请确保启动kafka服务器前，Zookeeper实例已经在运行，因为kafka的运行是需要zookeeper这种分布式应用程序协调服务。

进入kafka安装目录D:\bigdata\kafka_2.11-0.9.0.1

按下shift+鼠标右键，选择"在此处打开命令窗口"，打开命令行。

在命令行中输入：.\bin\windows\kafka-server-start.bat .\config\server.properties   回车。
