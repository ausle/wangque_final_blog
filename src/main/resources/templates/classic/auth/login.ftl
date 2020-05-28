<#include "/classic/inc/layout.ftl"/>
<@layout>


    <div class="col-3 mt-4" style="margin-left: 37.5%">
<#--        <div class="login-logo">-->
<#--            <a href="../../index2.html"><b>Admin</b>LTE</a>-->
<#--        </div>-->
        <!-- /.login-logo -->
        <div class="card">
            <div class="card-body login-card-body">
                <p class="login-box-msg">登录之旅</p>

                <#include "/classic/inc/action_message.ftl"/>

                <form class="form-group" action="${base}/login" method="post">
                    <div class="input-group mb-3">
                        <input class="form-control" type="text" name="username" value="asule" required placeholder="请输入用户名">
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-user"></span>
                            </div>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <input class="form-control" type="password"  name="password" value="qwerty" placeholder="请输入密码"required>
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-lock"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-8" style="    display: flex;align-items: flex-end;">
                            <div class="icheck-primary">
                                <input type="checkbox" id="remember" name="rememberMe">
                                <label for="remember">
                                    记住我
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-4">
                            <button type="submit" class="btn btn-primary btn-block">登录</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>

<#--                <div class="social-auth-links text-center mb-3">-->
<#--                    <p>- OR -</p>-->
<#--                    <a href="#" class="btn btn-block btn-primary">-->
<#--                        <i class="fab fa-facebook mr-2"></i> Sign in using Facebook-->
<#--                    </a>-->
<#--                    <a href="#" class="btn btn-block btn-danger">-->
<#--                        <i class="fab fa-google-plus mr-2"></i> Sign in using Google+-->
<#--                    </a>-->
<#--                </div>-->
<#--                <!-- /.social-auth-links &ndash;&gt;-->

                <p class="mb-1">
                    <a href="forgot-password.html">忘记密码</a>
                </p>
<#--                <p class="mb-0">-->
<#--                    <a href="register.html" class="text-center">Register a new membership</a>-->
<#--                </p>-->
            </div>
            <!-- /.login-card-body -->
        </div>
    </div>


</@layout>