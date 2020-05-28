<#macro layout>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>后台管理 - ${options['site_name']}</title>

    <!-- Favicons -->
<#--    <link rel="apple-touch-icon-precomposed" href="http://mtons.com/dist/images/logo.png"/>-->
<#--    <link rel="shortcut icon" href="http://mtons.com/dist/images/logo.png"/>-->

    <!-- Bootstrap -->
<#--    <link href="${base}/dist/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->

    <#--my css-->
    <link href="${base}/dist/css/admin-asule.css" rel="stylesheet">
    <link href="${base}/dist/css/admin-asule.css" rel="stylesheet">
    <link rel="stylesheet" href="${base}/dist/vendors/editormd/css/editormd.css" />

    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <#--font-->
    <link rel="stylesheet" href="${base}/dist/vendors/font-awesome/css/all.min.css">
    <link rel="stylesheet" href="${base}/dist/vendors/adminlte/css/adminlte.min.css">


    <!-- jQuery and bootstrap-->
    <script src="${base}/dist/js/jquery.min.js"></script>
    <script src="${base}/dist/vendors/bootstrap/js/bootstrap.bundle.min.js"></script>

    <#--jquery validation-->
    <script src='${base}/dist/vendors/jquery-validation/jquery.validate.min.js'></script>
    <script src='${base}/dist/vendors/jquery-validation/additional-methods.js'></script>
    <script src='${base}/dist/vendors/jquery-validation/localization/messages_zh.min.js'></script>
    <script src="${base}/dist/vendors/layer/layer.js"></script>


    <#--editormd-dialog-->
    <script src="${base}/dist/vendors/editormd/editormd.min.js" type="text/javascript"></script>
    <script src="${base}/dist/vendors/editormd/plugins/image-dialog/image-dialog.js" type="text/javascript"></script>
    <script src="${base}/dist/vendors/editormd/plugins/code-block-dialog/code-block-dialog.js" type="text/javascript"></script>
    <script src="${base}/dist/vendors/editormd/plugins/preformatted-text-dialog/preformatted-text-dialog.js" type="text/javascript"></script>
    <script src="${base}/dist/vendors/editormd/plugins/link-dialog/link-dialog.js" type="text/javascript"></script>
    <script src="${base}/dist/vendors/editormd/plugins/table-dialog/table-dialog.js" type="text/javascript"></script>


    <#--adminLTE-->
    <script src="${base}/dist/vendors/adminlte/js/adminlte.js"></script>


    <script type="text/javascript">
        var _WANGQUE = _WANGQUE || {};
        _WANGQUE.BASE_PATH = '${base}';
        _WANGQUE.LOGIN_TOKEN = '${profile.id}';
    </script>

    <#--sea.js-->
    <script src="${base}/dist/js/sea.js"></script>
    <script src="${base}/dist/js/sea.config.js"></script>
</head>
<body>


<div class="wrapper">
    <#--navbar-->
    <#include "/admin/inc/head.ftl">
    <#include "/admin/inc/sidebar.ftl">

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <#nested>
    </div>

</div>




</body>

</html>
</#macro>