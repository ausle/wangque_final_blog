

##  

使用DefaultWebSecurityManager作为shiro的SecurityManager。
会在创建该对象时，会把ServletContainerSessionManager作为默认的sessionManager。
而该sessionManager创建的HttpServletSession是servlet容器session的装饰，
那么此时的session是标准servlet容器支持的HttpSession实例，它不与Shiro的任何与会话相关的组件（如SessionManager，SecurityManager等）交互，完全由servlet容器管理。

而我这里重新设置的是DefaultWebSessionManager

<#--                        <div class="home article-item">-->
<#--                            <div class="row">-->
<#--                                <div class="col-8">-->
<#--                                    <h3>-->
<#--                                        <a>Spring Boot 使用 JSR303 实现参数验证 </a>-->
<#--                                    </h3>-->
<#--                                    <p class="color-content-1">-->
<#--                                        <a>JSR-303 是 JAVA EE 6 中的一项子规范，叫做 Bean Validation。JSR303 用于与 Java Bean 中的字段进行校验。......</a>-->
<#--                                    </p>-->
<#--                                    <div class="article-info">-->
<#--                                            <div class="size-sm color-content-2">-->
<#--                                                <img class="img-circle" src="${base}/dist/img/head.jpg" style="width: 20px;height: 20px">-->
<#--                                                <span class="ml-2">阿苏勒</span>-->
<#--                                                <i class="fa fa-calendar ml-2"></i> <span class="publish-date">2020-05-19</span>-->
<#--                                                <i class="fa fa-eye ml-2"></i> <span class="article-view">291</span>-->
<#--                                            </div>-->

<#--                                            <div>-->
<#--                                                <a href="#" class="tag-blog-1 size-sm">Spring boot</a>-->
<#--                                            </div>-->
<#--                                    </div>-->
<#--                                </div>-->

<#--                                <div class="col-4" style="display: flex;align-items: center;justify-content: center;">-->
<#--                                    <div class="author-img">-->
<#--                                        <img class="img-circle" src="${base}/dist/img/head.jpg" style="width: 120px;height:120px">-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->

<#--                            <div class="row">-->
<#--                                <div class="col-12 article-line"></div>-->
<#--                            </div>-->
<#--                        </div>-->

<#--                        &lt;#&ndash;top&ndash;&gt;-->
<#--                        <div class="home article-item">-->
<#--                            <div class="row">-->
<#--                                <div class="col-8">-->
<#--                                    <h3>-->
<#--                                        <a>Spring Boot 使用 JSR303 实现参数验证 </a>-->
<#--                                    </h3>-->
<#--                                    <p class="color-content-1">-->
<#--                                        <a>JSR-303 是 JAVA EE 6 中的一项子规范，叫做 Bean Validation。JSR303 用于与 Java Bean 中的字段进行校验。......</a>-->
<#--                                    </p>-->
<#--                                    <div class="article-info">-->
<#--                                        <div class="size-sm color-content-2">-->
<#--                                            <img class="img-circle" src="${base}/dist/img/head.jpg" style="width: 20px;height: 20px">-->
<#--                                            <span class="ml-2">阿苏勒</span>-->
<#--                                            <i class="fa fa-calendar ml-2"></i> <span class="publish-date">2020-05-19</span>-->
<#--                                            <i class="fa fa-eye ml-2"></i> <span class="article-view">291</span>-->
<#--                                        </div>-->

<#--                                        <div>-->
<#--                                            <a href="#" class="tag-blog-1 size-sm">Spring boot</a>-->
<#--                                        </div>-->
<#--                                    </div>-->
<#--                                </div>-->

<#--                                <div class="col-4" style="display: flex;align-items: center;justify-content: center;">-->
<#--                                    <div class="author-img">-->
<#--                                        <img class="img-circle" src="${base}/dist/img/head.jpg" style="width: 120px;height:120px">-->
<#--                                    </div>-->
<#--                                </div>-->
<#--                            </div>-->

<#--                            <div class="row">-->
<#--                                <div class="col-12 article-line"></div>-->
<#--                            </div>-->
<#--                        </div>-->