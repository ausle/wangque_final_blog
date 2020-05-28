<#include "/admin/inc/layout.ftl"/>
<@layout>
    <!-- 页面头部 -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark">文章编辑</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="/admin">首页</a></li>
                        <li class="breadcrumb-item"><a href="/admin/article/list">文章管理</a></li>
                        <li class="breadcrumb-item active">文章编辑</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>


<section class="content">

 <form id="submitForm" class="form col-md-12" action="${base}/admin/article/submit"
                      method="post" enctype="multipart/form-data">

     <input type="hidden" name="status" value="${view.status!0}"/>
     <#if view??>
         <input type="hidden" name="id" value="${view.id}"/>
         <input type="hidden" name="authorId" value="${view.authorId}"/>
     </#if>

     <input type="hidden" id="thumbnail" name="thumbnail" value="${view.thumbnail}"/>


    <div class="container-fluid">
        <div class="row">

            <div class="col-md-9">
                <div class="card card-pink card-outline">
                    <div class="card-header">
                        <h5 class="card-title m-0">文章编辑</h5>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <input type="text" class="form-control" id="title" name="title" placeholder="文章标题" required>
                        </div>

                        <div class="form-group">
                            <div id="test-editor" style="z-index: 2">
                                <textarea style="display:none;" name="content" id="content" required></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-3">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card card-purple card-outline">
                            <div class="card-header">
                                <h5 class="card-title m-0">预览图</h5>
                            </div>
                            <div class="card-body">
                                        <div class="thumbnail-box">
                                            <div class="convent_choice" id="thumbnail_image"/>
                                            <div class="custom-file mt-4" id="upload_btn">
                                                <input type="file" class="custom-file-input" id="exampleInputFile">
                                                <label class="custom-file-label" for="exampleInputFile">点击选择一张图片</label>
                                            </div>
                                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card card-primary card-outline">
                            <div class="card-header">
                                <h5 class="card-title m-0">栏目</h5>
                            </div>
                            <div class="card-body">
                                <select class="form-control" name="channelId" aria-invalid="false" required>
                                    <option value="">请选择栏目</option>
                                    <#list channels as row>
                                        <option value="${row.id}" <#if (view.channelId == row.id)> selected </#if>>${row.name}</option>
                                    </#list>
                                </select>

                                <div class="form-group mt-2">
                                    <input class="form-control" placeholder="请输入要添加的标签" type="text" id="tags" name="tags">
                                </div>

                                <div class="box-add" style="display: flex;justify-content: space-between;">
                                    <a class="btn btn-default btn-sm" href="/admin/article/post">草稿</a>
                                    <a class="btn btn-primary btn-sm" data-status="0" event="post_submit">发布</a>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
        </form>
    </div>
</section>




<#--    <script type="text/javascript">-->
<#--            $(function() {-->
<#--                var editor = editormd("test-editor", {-->
<#--                    placeholder:'debug world',-->
<#--                    width: "100%",-->
<#--                    height: 700,-->
<#--                    toolbarIcons : function() {-->
<#--                        return ["undo","redo","|","bold","del","italic","quote","|","|","list-ul","list-ol","hr","|","link","reference-link","image","code","preformatted-text","code-block","table","|","watch","preview","fullscreen","clear"];-->
<#--                    },-->

<#--                    path:"../../static/dist/vendors/editormd/lib/",-->

<#--                    mode:"markdown",-->
<#--                    theme: "default",//工具栏主题-->
<#--                    editorTheme: "default",//编辑主题-->
<#--                    previewTheme: "default",//预览主题-->
<#--                    watch:false,//关闭实时预览-->


<#--                    imageUpload: true,-->
<#--                    imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],-->
<#--                    imageUploadURL :"http://localhost/admin/article/post/upload-editormd?crop=thumbnail_post_size",-->

<#--                    syncScrolling: "single",-->
<#--                    saveHTMLToTextarea: true,-->
<#--                    emoji: false,-->
<#--                    taskList: true,-->
<#--                    tocm: true,                  // Using [TOCM]-->
<#--                    tex: true,                   // 开启科学公式TeX语言支持，默认关闭-->
<#--                    flowChart: true,             // 开启流程图支持，默认关闭-->
<#--                    sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,-->

<#--                    onresize: function() {-->
<#--                        this.editor.css({-->
<#--                            width  : (typeof this.settings.width  === "number") ? this.settings.width  + "px" : this.settings.width,-->
<#--                            height : (typeof this.settings.height === "number") ? this.settings.height + "px" : this.settings.height-->
<#--                        });-->
<#--                    },-->
<#--                    onload:function(){-->
<#--                        $(".editormd-preview-close-btn").css("display","none");-->
<#--                    },-->
<#--                });-->

<#--                //工具栏是否固定定位-->
<#--                editor.setToolbarAutoFixed(false);-->
<#--            });-->
<#--    </script>-->


    <script type="text/javascript">
        seajs.use('post', function (post) {
            post.init();
        });
    </script>
</@layout>
