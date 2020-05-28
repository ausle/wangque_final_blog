

#spring security工作流程

(1)当浏览器表单请求时，若需要验证，则通过UsernamePasswordAuthenticationFilter的doFilter进行处理。
根据username、password封装UsernamePasswordAuthenticationToken。（它是authentication类型）此时它的authentication为false，principal为表单用户名，credentials为表单密码。
在setDetails时，会创建session。
把验证交给ProviderManager进行处理。

(2)
会遍历provider，最后找到一个名为DaoAuthenticationProvider进行验证。
会调用我们实现的UserDetailsService的loadUserByUsername，从数据库查找对应的账号密码封装为User返回给security。

security接下来拿着UsernamePasswordAuthenticationToken中的密码(表单的密码)和User的密码(数据库的密码)，交给注册的passwordEncoder进行匹配。
若匹配不成功，则抛出BadCredentialsException异常。
若匹配成功，代表验证通过，会去创建一个success的authentication，同样也是UsernamePasswordAuthenticationToken。此时authentication为true，验证成功。


(3)
把AuthenticationToken添加到securityContext中。
判断request是否包含有remember-me值， 若有则表示启用自动登录功能。

获取cookie的有效时间，默认值为两个星期的秒数。
根据username、password和expireTime经过MD5加密，生成签名。
添加cookie。默认名字也是remember-me。

获取跳转的url，若我们设置了defaultSuccessUrl，就会请求重定向到该路径。


# 自动登录(数据库自动登录)
某些情况下，需要服务器重启后，依旧可以进行自动登录。那么就需要将cookie-value写入数据库。它与用户名进行关联。
下次登录时，获取客户端的cookie值，到数据库去查询，若查找的到，就被认为验证通过。

# 异常处理
验证失败的情况下，会抛出异常。security中常见的异常有：


处理这些异常都会调用unsuccessfulAuthentication。会交由SimpleUrlAuthenticationFailureHandler的onAuthenticationFailure处理。
会判断defaultFailureUrl是否为null，默认情况下，如果登录页面为/login，那么对应的跳转失败的页面为/login?error。
跳转前，如果是请求转发，把验证异常信息添加到request中。如果是重定向，添加到session域中。对应的key为：SPRING_SECURITY_LAST_EXCEPTION。

要解决这个问题，可以自己定义一个defaultFailureUrl，把异常信息输出到页面显示。




