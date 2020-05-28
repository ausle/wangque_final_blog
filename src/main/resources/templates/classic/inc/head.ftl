
<#--<nav class="navbar navbar-fixed-top navbar-has-shadow" role="navigation">-->
<#--        <div class="container">-->
<#--            <div class="navbar-header">-->
<#--                <button type="button" class="navbar-toggle" data-target="#asule-navbar" data-toggle="collapse">-->
<#--                    <span class="sr-only">切换导航</span>-->
<#--                    <span class="icon-bar"></span>-->
<#--                    <span class="icon-bar"></span>-->
<#--                    <span class="icon-bar"></span>-->
<#--                </button>-->
<#--                <a class="navbar-brand asule-navbar-brand" href="#">-->
<#--                    ASULE-->
<#--                </a>-->
<#--            </div>-->

<#--            <div id="asule-navbar" class="collapse navbar-collapse">-->
<#--                <ul class="nav navbar-nav navbar-left asule-navbar-nav">-->
<#--                    <li>-->
<#--                        <a  href="/product/">Product</a>-->
<#--                    </li>-->
<#--                    <li><a  href="/customers/">Customers</a></li>-->
<#--                    <li><a  href="/case-studies/">Case Studies</a></li>-->
<#--                    <li><a  href="/community/">Community</a></li>-->
<#--                    <li><a  href="/pricing/">Pricing</a></li>-->
<#--                    <li class="dropdown">-->
<#--                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"-->
<#--                           aria-haspopup="true">Help <span class="caret"></span></a>-->
<#--                        <ul class="dropdown-menu">-->
<#--                            <li><a  href="/help/">Knowledge Base</a></li>-->
<#--                            <li><a  target="_blank">Forum</a></li>-->
<#--                        </ul>-->
<#--                    </li>-->
<#--                </ul>-->

<#--                <ul class="nav navbar-nav navbar-right asule-navbar-nav">-->

<#--                    <li>-->
<#--                        <form class="form-inline ml-3">-->
<#--                            <div class="input-group input-group-sm">-->
<#--                                <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">-->
<#--                                <div class="input-group-append">-->
<#--                                    <button class="btn btn-navbar" type="submit">-->
<#--                                        <i class="fas fa-search"></i>-->
<#--                                    </button>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                        </form>-->
<#--                    </li>-->

<#--                    <#if profile??>-->

<#--                        <@controls name="post">-->
<#--                            <li>-->
<#--                                <a href="${base}/post/editing" class="plus"><i class="icon icon-note"></i> 写文章</a>-->
<#--                            </li>-->
<#--                        </@controls>-->

<#--                        <li class="dropdown">-->
<#--                            <a href="#" class="user dropdown-toggle" data-toggle="dropdown" style="margin-top: 8.5px;-->
<#--    padding: 10px 10px;">-->
<#--                                <img class="img-circle"-->
<#--                                     src="${base}/dist/img/head.jpg"-->
<#--                                     style="width: 35px;height: 35px">-->
<#--                                <span>${profile.name}</span>-->
<#--                                <span class="caret"></span>-->
<#--                            </a>-->
<#--                            <ul class="dropdown-menu">-->
<#--                                <li><a href="${base}/admin">后台管理</a></li>-->
<#--                                <li><a href="${base}/logout">退出</a></li>-->
<#--                            </ul>-->
<#--                        </li>-->

<#--                        <#else>-->
<#--                            <li><a href="${base}/register" class="btn btn-sm btn-primary">注册</a></li>-->
<#--                            <li><a href="${base}/register" class="btn btn-sm btn-secondary">登录</a></li>-->


<#--                            <li><a href="${base}/do/login" id="asule-btn" style="    padding: 10px 15px;margin-top: 15px;-->
<#--margin-left: 10px;">登录</a></li>-->
<#--                    </#if>-->


<#--                </ul>-->
<#--            </div>-->
<#--        </div>-->
<#--</nav>-->


<#--<nav class="main-header navbar navbar-expand navbar-white navbar-light">-->

<#--    <!-- Left navbar links &ndash;&gt;-->
<#--    <ul class="navbar-nav">-->
<#--        <li class="nav-item">-->
<#--            <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>-->
<#--        </li>-->
<#--        <li class="nav-item d-none d-sm-inline-block">-->
<#--            <a href="index3.html" class="nav-link">Home</a>-->
<#--        </li>-->
<#--        <li class="nav-item d-none d-sm-inline-block">-->
<#--            <a href="#" class="nav-link">Contact</a>-->
<#--        </li>-->
<#--    </ul>-->

<#--    <!-- SEARCH FORM &ndash;&gt;-->
<#--    <form class="form-inline ml-3">-->
<#--        <div class="input-group input-group-sm">-->
<#--            <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">-->
<#--            <div class="input-group-append">-->
<#--                <button class="btn btn-navbar" type="submit">-->
<#--                    <i class="fas fa-search"></i>-->
<#--                </button>-->
<#--            </div>-->
<#--        </div>-->
<#--    </form>-->


<#--    <!-- Right navbar links &ndash;&gt;-->
<#--    <ul class="navbar-nav ml-auto">-->
<#--        <li class="nav-item dropdown">-->
<#--            <a class="nav-link" data-toggle="dropdown" href="#">-->
<#--                <i class="far fa-comments"></i>-->
<#--                <span class="badge badge-danger navbar-badge">3</span>-->
<#--            </a>-->
<#--            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">-->
<#--                <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>-->
<#--            </div>-->
<#--        </li>-->
<#--    </ul>-->


<#--</nav>-->


<nav class="main-header navbar navbar-expand navbar-white navbar-light" style="margin-left: 0px;">

    <div class="container">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/index" class="nav-link">首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">分类</a>
            </li>
        </ul>
    <div>



    <!-- Right navbar links -->
    <ul class="navbar-nav" style="display: flex;align-items: center;">
        <li class="nav-item">
            <!-- SEARCH FORM -->
            <form class="form-inline">
                <div class="input-group input-group-sm">
                    <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-navbar" type="submit">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </li>


        <#if profile??>

            <li class="nav-item dropdown ml-4">
                <a class="nav-link" data-toggle="dropdown" href="#" aria-expanded="false" style="padding: 0px;">
                    <img class="img-circle" src="${base}/dist/img/head.jpg" style="width: 40px;height: 40px">
                    <span>${profile.name}</span>
                    <span class="caret"></span>
                </a>


                <div class="dropdown-menu dropdown-menu-md-right">
                    <a class="dropdown-item" href="${base}/admin">后台管理</a>
                    <a class="dropdown-item" href="${base}/logout">退出</a>
                </div>

            </li>

            <#else>
                <li class="nav-item ml-4"><a href="${base}/register" class="nav-link">注册</a></li>
                <li class="nav-item mr-2"><a href="${base}/do/login" class="nav-link">登录</a></li>
        </#if>




    </ul>
</nav>


