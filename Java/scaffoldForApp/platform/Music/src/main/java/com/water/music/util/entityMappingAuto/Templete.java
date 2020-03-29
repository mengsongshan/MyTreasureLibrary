package com.water.music.util.entityMappingAuto;

import java.util.Map;

public
interface Templete {
    void buildHeader(TempleteWriter writer);
    void buildBody(TempleteWriter writer,Map<String,String> content);
    void buildBottom(TempleteWriter writer);
}
