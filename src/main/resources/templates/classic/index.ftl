<#include "/classic/inc/layout.ftl">
<@layout>

    <div class="container" style="padding: 30px 0px">
        <div class="row">

            <div class="col-8">
                <div class="card">
                    <div class="card-header" style="display: flex;align-items: center;">
                        <h3 class="card-title color-primary text-bold">博客</h3>

                        <div class="card-desc" style="position: absolute;right: 19px;">
                            <span class="color-content-1 ">共<span class="color-secondary size-lg">97</span>篇</span>
                        </div>
                    </div>

                    <div class="card-body">
                            <@contents>
                                <#include "/classic/inc/article_item.ftl" />
                                <#list results.content as row>
                                    <@article_item row />
                                </#list>

                                <#if  results.content?size == 0>
                                        <div class="posts-item">该目录下还没有内容!</div>
                                </#if>
                            </@contents>
                    </div>

                </div>
            </div>

            <div class="col-4">

                <div class="row">

                    <div class="col-12">
                        <div class="card">
                            <div class="card-header" style="display: flex;align-items: center;">
                                <h4 class="card-title color-secondary text-bold">分类</h4>

                                <div class="card-desc" style="position: absolute;right: 19px;">
                                    <span class="color-content-1 size-sm">
                                        <a>更多<span> >></span></a>
                                        </span>
                                </div>
                            </div>

                            <div class="card-body">

                                <div class="article-channel-info">
                                    <a href="/types/2" class="item">
                                        <span>Spring Cloud</span>
                                        <div class="point">27</div>
                                    </a>
                                    <a href="/types/2" class="item">
                                        <span>Spring Cloud</span>
                                        <div class="point">27</div>
                                    </a>
                                    <a href="/types/2" class="item">
                                        <span>Spring Cloud</span>
                                        <div class="point">27</div>
                                    </a>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 mt-2">
                        <div class="card">
                            <div class="card-header" style="display: flex;align-items: center;justify-content: space-between">
                                <h3 class="card-title">标签</h3>
                            </div>

                            <div class="card-body">
                                body
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>



</@layout>