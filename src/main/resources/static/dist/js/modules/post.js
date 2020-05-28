

define(function (require,exports,module) {
    J = jQuery;
    require('tagsinput');

    var PostView = function () {};

    PostView.prototype={
        name : 'PostView',
        init : function () {

            this.bindEvents();
        },

        bindEvents : function () {
            var that = this;

            that.bindTagit();
            that.bindEditorMd();
            that.bindValidate();
            that.bindUpload();

            $('a[event="post_submit"]').click(function () {
                var status = $(this).data('status');
                $("input[name='status']").val(status);
                // var editorView=editormd.markdownToHTML("test-editor",{
                //
                //     markdown        : "markdown" ,//+ "\r\n" + $("#append-test").text(),
                //     //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                //     htmlDecode      : "style,script,iframe",  // you can filter tags decode
                //     //toc             : false,
                //     tocm            : true,    // Using [TOCM]
                //     //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
                //     //gfm             : false,
                //     //tocDropdown     : true,
                //     // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
                //     emoji           : true,
                //     taskList        : true,
                //     tex             : true,  // 默认不解析
                //     flowChart       : true,  // 默认不解析
                //     sequenceDiagram : true,  // 默认不解析
                // })
                //
                // console.log(editorView.getMarkdown());
                $("#submitForm").submit();
            });
        },

        bindEditorMd : function () {
            window.editor = editormd("test-editor", {
                placeholder:'debug world',
                width: "100%",
                height: 700,
                toolbarIcons : function() {
                    return ["undo","redo","|","bold","del","italic","quote","|","|","list-ul","list-ol","hr","|","link","reference-link","image","code","preformatted-text","code-block","table","|","watch","preview","fullscreen","clear"];
                },

                path:"../../static/dist/vendors/editormd/lib/",

                mode:"markdown",
                theme: "default",//工具栏主题
                editorTheme: "default",//编辑主题
                previewTheme: "default",//预览主题
                watch:false,//关闭实时预览

                imageUpload: true,
                imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                imageUploadURL :"http://localhost/admin/article/post/upload-editormd?crop=thumbnail_post_size",

                syncScrolling: "single",
                saveHTMLToTextarea: true,
                emoji: false,
                taskList: true,
                tocm: true,                  // Using [TOCM]
                tex: true,                   // 开启科学公式TeX语言支持，默认关闭
                flowChart: true,             // 开启流程图支持，默认关闭
                sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,

                onresize: function() {
                    this.editor.css({
                        width  : (typeof this.settings.width  === "number") ? this.settings.width  + "px" : this.settings.width,
                        height : (typeof this.settings.height === "number") ? this.settings.height + "px" : this.settings.height
                    });
                },
                onload:function(){
                    $(".editormd-preview-close-btn").css("display","none");
                },
            });

            //工具栏是否固定定位
            editor.setToolbarAutoFixed(false);


        },


        bindTagit : function () {
            $('#tags').tagsInput(
                {
                    // 'autocomplete_url': url_to_autocomplete_api,
                    // 'autocomplete': {option: value, option: value},
                    'height': '50px',
                    'width': '200px',
                    'interactive': true, //是否可以通过输入增加标签，总可以通过addTag函数增加标签
                    'defaultText': 'add a tag',           //默认提示文字
                    // 'onAddTag': callback_function,        //增加标签时执行回调函数
                    // 'onRemoveTag': callback_function,     //删除标签时执行回调函数
                    // 'onChange': callback_function,      //标签变化时执行回调函数
                    // 'delimiter': [',', ';'],              //或单独分隔符. 例如: ';'
                    'removeWithBackspace': true,  //是否可通过Backspace键删除标签
                    'minChars': 0,
                    'maxChars': 4,    // if not provided there is no limit
                    'placeholderColor': '#ff0000'
                }
            );
        },

        bindValidate: function () {
            require.async(['validation'], function () {
                require.async(['validation-additional'], function () {
                    $("#submitForm").validate({
                        ignore: "",
                        rules: {
                            title: 'required',
                            channelId: 'required',
                            content: {
                                required: true,
                                check_editor: true
                            }
                        },
                        messages: {
                            title: '请输入标题',
                            channelId: '请选择栏目',
                            content: {
                                required: '内容不能为空',
                                check_editor: '内容不能为空'
                            }
                        },
                        errorElement: "p",
                        errorPlacement: function (error, element) {
                            error.addClass("help-block");
                            if (element.prop("type") === "checkbox") {
                                error.insertAfter(element.parent("label"));
                            } else if (element.is("textarea")) {
                                error.insertBefore(element.closest(".form-group"));
                            } else {
                                error.insertAfter(element);
                            }
                        },
                        highlight: function (element, errorClass, validClass) {
                            $(element).closest("div").addClass("has-error").removeClass("has-success");
                        },
                        unhighlight: function (element, errorClass, validClass) {
                            $(element).closest("div").addClass("has-success").removeClass("has-error");
                        }
                    });
                });
            });
        },



        bindUpload : function () {
            $('#upload_btn').change(function(){

                var file=$(this)[0].children[0].files[0];


                // var file=$(this)[0].files;


                if(!file){
                    return false;
                }
                var form=new FormData();
                form.append("file",file);

                $.ajax({
                    url: _WANGQUE.BASE_PATH + "/admin/article/post/upload?crop=thumbnail_post_size",
                    data: form,
                    type: "POST",
                    cache: false, //上传文件无需缓存
                    processData: false,
                    contentType: false,
                    success:function (result) {
                        if(result.success===1){
                            // layer.alert(result.message);
                            var path=result.url;
                            $("#thumbnail_image").css("background", "url(" + path + ") no-repeat scroll center 0 rgba(0, 0, 0, 0)");
                            $("#thumbnail").val(path);
                        }else {
                            layer.alert(result.message);
                        }
                    },
                    error:function (result) {
                        console.log(result);
                    }
                });


            });
        },
    };

    exports.init = function () {
        new PostView().init();
    }

})