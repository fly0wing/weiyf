#1.初始化SDK
在商户调用SDK的初始化方法时进行SDK的初始化。
##输入：
要求商户传入：入口标识entryId、entryKey、联网要求：强弱。

##输出：
联网要求：强则即时联网，建立会话，弱则根据上次联网时间可能暂时不联网。
根据需要联网建立会话。

#2.激活终端
激活的目的，是收集终端信息，为终端分配终端标识。
同时，自动建立会话。
##输入：
* 商户传入：entryId、entryKey
* 终端指纹及其相关信息，如：终端类型、终端名称、OS、屏幕大小

##处理：
* 确定终端标识。
* 建立会话。

##输出：
* 终端标识：根据终端指纹从服务端获取。
* 会话标识：后续全部的交互都需要传入会话标识。

#3.建立会话
会话的目的，在一定时间内，建立计费应用和平台间建立信息共享的机制。
需要考虑用户在同一个终端上，同时使用多款计费应用，会话的KEY值：“”
##输入：
商户传入：entryId、entryKey
SDK本地保存的信息：
1、终端标识：首次没有则传入0，需要SDK根据终端指纹从服务端获取。
2、终端指纹：
3、用户标识：在用户成功登录（包括匿名登录）一次过后，否则传入0。
4、会话标识：
地理信息：

##处理：
确定会话标识，如果已经超时，则重新产生。
确定终端标识，没有则根据终端指纹产生“getTerminalByFingerprint”。
##输出：
* 终端标识：根据终端指纹从服务端获取。
* 会话标识：后续全部的交互都需要传入会话标识。

#4.注册和登录
##注册、登录时机
###在商户要求用户登录时
用户选择匿名登录，则进行匿名注册
###在用户购买前

##注册
包括匿名注册。
如果是手机号注册，需要先验证用户手机号的真实性（requestActionToken）。一般账号可以先检查该账号是否已被别人注册过。
注册成功则自动完成登录过程。
###输入：
* 会话标识：
* 登录账号、密码、账号类型
* 本次登录的令牌：

###处理：
* 检查会话的有效性（后续全部会话均需要检查）。
* 验证账号和密码的有效性
* 注册手机号重复的情况下，如果只是一个空的用户或者用户终端是一样的，则直接复用之前的用户？
    用户可以选择重新创建新用户，则直接创建，把老的用户手机号登录取消。
    如果存在账户余额或有效订阅，则可以提示通过页面或客服找回。
    
* 自动完成用户和终端之间的绑定。

###输出：
* 用户标识

##登录
不考虑在同一个终端上，同时有两个用户再使用。
默认是自动登录，用户可以修改配置。
###输入：
* 会话标识：
* 如果是自动登录：上次登录的令牌“loginToken”、用户标识：在用户成功登录一次过后，否则传入0
* 登录账号、密码、账号类型（自动登录时不需要传入）

###处理：
如果是自动登录，在没有传入用户标识则根据需要进行匿名用户注册；否则需要根据用户标识验证用户的上次登录的令牌。
如果安全级别不高，终端没有绑定自动完成用户和终端之间的绑定。
如果安全级别高，终端没有绑定，则需要通过专门的绑定API完成用户和终端之间的绑定。

###输出：
用户标识：
本次登录的令牌：
令牌的失效时间？


#5.获取入口商品信息
###输入： 
* 会话标识：
* 产品标识，可选

###处理：
 
###输出：
* 商品列表：

#计费请求



