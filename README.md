# weilog
新浪微博第三方客户端
2017年9月18日
终于找到readme总是丢失的原因了，因为我在网页上写readme，项目一旦push，readme不在项目里，就会被删，继续写
前几天成功获取授权，得到token，并将token存入了sharepreferences中。然后又通过token获取到了uid。
今天通过uid和token获取个人数据，遇到问题：app运行时，不能正常运行，也没有错误警告弹出。
下一步问题：怎么在listview中将获取的数据加载出来，目前已经找到相关资料