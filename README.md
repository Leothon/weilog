# weilog
新浪微博第三方客户端日志
2017年9月18日
##################################################################################
终于找到readme总是丢失的原因了，因为我在网页上写readme，项目一旦push，readme不在项目里，就会被删，继续写
前几天成功获取授权，得到token，并将token存入了sharepreferences中。然后又通过token获取到了uid。
今天通过uid和token获取个人数据，遇到问题：app运行时，不能正常运行，也没有错误警告弹出。
下一步问题：怎么在listview中将获取的数据加载出来，目前已经找到相关资料
已经完成个人信息的json数据请求，并导入控件。
不能正常运行的原因是上次导入的sdk残留。
问题：
1、找到合适的json数据解析方式
2、异步加载图片方式
3、listview数据加载。
###############################################################################
2017年10月10日
################################################################################
写一个公用实体类，将众多元素都写get，set方法。
到时候将解析的Json数据解析后，通过getset设置到控件中去。