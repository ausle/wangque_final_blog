<#include "/classic/inc/layout.ftl"/>
<@layout>
<#--    <div class="col-md-4 col-md-offset-4 asule-form">-->
<#--        <form class="form-group" action="${base}/register" method="post" id="submitForm">-->
<#--            <div class="form-group">-->
<#--                <label for="name">用户名</label>-->
<#--                <input class="form-control" type="text" placeholder="字母或数字的组合,不少于5位" name="username" required>-->
<#--            </div>-->
<#--            <div class="form-group">-->
<#--                <label for="name">密码</label>-->
<#--                <input class="form-control" type="password" placeholder="请输入密码" maxlength="18" name="password" id="password" required>-->
<#--            </div>-->
<#--            <div class="form-group">-->
<#--                <label for="name">确认密码</label>-->
<#--                <input class="form-control" type="password" placeholder="请再一次输入密码" maxlength="18" name="password2" id="password2" required>-->
<#--            </div>-->
<#--            <button type="submit" class="btn-block" id="asule-btn">注册</button>-->
<#--        </form>-->
<#--    </div>-->


    <div class="col-3 mt-4" style="margin-left: 37.5%">
        <#--        <div class="login-logo">-->
        <#--            <a href="../../index2.html"><b>Admin</b>LTE</a>-->
        <#--        </div>-->
        <!-- /.login-logo -->
        <div class="card">
            <div class="card-body login-card-body">
                <p class="login-box-msg">注册</p>

                <#include "/classic/inc/action_message.ftl"/>

                <form class="form-group" action="${base}/register" method="post" id="submitForm">
                    <div class="input-group mb-3">
                        <input class="form-control" type="text" placeholder="字母或数字的组合,不少于5位" name="username" required>
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-user"></span>
                            </div>
                        </div>
                    </div>
                    <div class="input-group mb-3">
                        <input class="form-control" type="password" placeholder="请输入密码" maxlength="18" name="password" id="password" required>
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-lock"></span>
                            </div>
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <input class="form-control" type="password" placeholder="请再一次输入密码" maxlength="18" name="password2" id="password2" required>
                        <div class="input-group-append">
                            <div class="input-group-text">
                                <span class="fas fa-lock"></span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <!-- /.col -->
                        <div class="col-4 offset-8">
                            <button type="submit" class="btn btn-primary btn-block">注册</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>

            </div>
            <!-- /.login-card-body -->
        </div>
    </div>





    <script type="text/javascript">
        seajs.use('validate', function (validate) {
            validate.register('#submitForm');
        });
    </script>

</@layout>