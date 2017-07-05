root package结构：com.example.myproject
应用主类Application.java置于root package下，通常我们会在应用主类中做一些框架配置扫描等配置，我们放在root package下可以帮助程序减少手工配置来加载到我们希望被Spring加载的内容
实体（Entity）与数据访问层（Repository）置于com.example.myproject.domain包下
逻辑层（Service）置于com.example.myproject.service包下
Web层（web）置于com.example.myproject.web包下