<#include "/admin/inc/layout.ftl"/>
<@layout>


    <!-- 页面头部 -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark">文章管理</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">首页</a></li>
                        <li class="breadcrumb-item active">文章管理</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->


<!-- 主体内容-->
<section class="content">
    <div class="container-fluid">
        <div class="row">

            <div class="col-12">
                <div class="card">
                    <div class="card-header" style="display: flex;align-items: center;justify-content: space-between">
                        <h3 class="card-title">文章列表</h3>

                        <div class="box-add" style="position: absolute;right: 19px;top: 9px;">
                            <a class="btn btn-default btn-sm" href="/admin/article/post">新建</a>
                            <a class="btn btn-default btn-sm" href="javascrit:;" data-action="batch_del">批量删除</a>
                        </div>

                    </div>

                    <div class="card-body">

                        <div>

                            <div class="row">
                                <div class="col-md-12">

                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <select class="form-control">

                                                    <option value="">请选择栏目</option>
                                                    <#list channels as row>
                                                        <option value="${row.id}" <#if (view.channelId == row.id)> selected </#if>>${row.name}</option>
                                                    </#list>
<#--                                                    <option value="0">查询所有栏目</option>-->
<#--                                                    <option value="1">banner</option>-->
<#--                                                    <option value="2">博客</option>-->
<#--                                                    <option value="3">随笔</option>-->
<#--                                                    <option value="4">分享</option>-->
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-5 ml-3">
                                            <form class="form-inline">
                                                <div class="input-group input-group-sm" style="background-color: #f2f4f6;">
                                                    <input class="form-control form-control-navbar"
                                                           style="background-color: #f2f4f6;border: 0;padding: 19px"
                                                           type="search" placeholder="Search" aria-label="Search">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-navbar" type="submit">
                                                            <i class="fas fa-search"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>


<#--                                    <select name="channelId" data-select="0">-->
<#--                                        <option value="0">查询所有栏目</option>-->
<#--                                        <option value="1">banner</option>-->
<#--                                        <option value="2">博客</option>-->
<#--                                        <option value="3">随笔</option>-->
<#--                                        <option value="4">分享</option>-->
<#--                                    </select>-->

                                    <!-- SEARCH FORM -->

                                </div>
                            </div>

                        </div>


                        <table id="example2" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>文章标题</th>
                                <th>作者</th>
                                <th>发布时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <th scope="row">泛Mooc职业教育， 效果和就业为王</th>
                                <td>朱朝兵</td>
                                <td>2015/08/08</td>
                                <td>
                                    <div role="presentation" class="dropdown">
                                        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                            操作<span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">编辑</a></li>
                                            <li><a href="#">删除</a></li>
                                            <li><a href="#">全局置顶</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>







<#--            <div class="col-md-10 col-md-offset-1">-->

<#--                <div class="box-outer">-->
<#--                    <div class="box-title">文章管理</div>-->
<#--                    <div class="box-return">-->
<#--                        <div>-->
<#--                            <a href="/admin">首页</a><span> > </span> <a href="/admin/article/list">文章列表</a>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </div>-->


<#--                <div class="box-header">-->
<#--                    <div class="box-title">文章列表</div>-->
<#--                    <div class="box-tools">-->
<#--                        <a class="btn btn-default btn-sm" href="${base}/admin/article/post">新建</a>-->
<#--                        <a class="btn btn-default btn-sm" href="javascrit:;" data-action="batch_del">批量删除</a>-->
<#--                    </div>-->
<#--                </div>-->

<#--                <table class="table">-->
<#--                    <thead>-->
<#--                    <tr>-->
<#--                        <th>文章标题</th>-->
<#--                        <th>作者</th>-->
<#--                        <th>发布时间</th>-->
<#--                        <th>操作</th>-->
<#--                    </tr>-->
<#--                    </thead>-->
<#--                    <tbody>-->
<#--                    <tr>-->
<#--                        <th scope="row">泛Mooc职业教育， 效果和就业为王</th>-->
<#--                        <td>朱朝兵</td>-->
<#--                        <td>2015/08/08</td>-->
<#--                        <td>-->
<#--                            <div role="presentation" class="dropdown">-->
<#--                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">-->
<#--                                    操作<span class="caret"></span>-->
<#--                                </button>-->
<#--                                <ul class="dropdown-menu">-->
<#--                                    <li><a href="#">编辑</a></li>-->
<#--                                    <li><a href="#">删除</a></li>-->
<#--                                    <li><a href="#">全局置顶</a></li>-->
<#--                                </ul>-->
<#--                            </div>-->
<#--                        </td>-->
<#--                    </tr>-->


<#--                    <tr>-->
<#--                        <th scope="row">泛Mooc职业教育， 效果和就业为王</th>-->
<#--                        <td>朱朝兵</td>-->
<#--                        <td>2015/08/08</td>-->
<#--                        <td>-->
<#--                            <div role="presentation" class="dropdown">-->
<#--                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">-->
<#--                                    操作<span class="caret"></span>-->
<#--                                </button>-->
<#--                                <ul class="dropdown-menu">-->
<#--                                    <li><a href="#">编辑</a></li>-->
<#--                                    <li><a href="#">删除</a></li>-->
<#--                                    <li><a href="#">全局置顶</a></li>-->
<#--                                </ul>-->
<#--                            </div>-->
<#--                        </td>-->
<#--                    </tr>-->
<#--                    </tbody>-->
<#--                </table>-->
<#--            </div>-->


</section>


</@layout>
