(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-261045d2"],{"2d1e":function(e,t,n){},ab07:function(e,t,n){"use strict";n("2d1e")},beb3:function(e,t,n){"use strict";n.r(t);n("b0c0");var s=function(){var e=this,t=e._self._c;return t("div",[t("el-row",{staticClass:"do-exam-title",staticStyle:{"background-color":"#F5F5DC"}},[t("el-col",{attrs:{span:24}},e._l(e.answer.answerItems,(function(n){return t("span",{key:n.itemOrder},[t("el-tag",{staticClass:"do-exam-title-tag",attrs:{type:e.questionDoRightTag(n.doRight)},on:{click:function(t){return e.goAnchor("#question-"+n.itemOrder)}}},[e._v(e._s(n.itemOrder))])],1)})),0)],1),t("el-row",{staticClass:"do-exam-title-hidden"},[t("el-col",{attrs:{span:24}},e._l(e.answer.answerItems,(function(n){return t("span",{key:n.itemOrder},[t("el-tag",{staticClass:"do-exam-title-tag"},[e._v(e._s(n.itemOrder))])],1)})),0)],1),t("el-container",{staticClass:"app-item-contain"},[t("el-header",{staticClass:"align-center"},[t("h1",[e._v(e._s(e.form.name))]),t("div",[t("span",{staticClass:"question-title-padding"},[e._v("试卷得分："+e._s(e.answer.score))]),t("span",{staticClass:"question-title-padding"},[e._v("试卷耗时："+e._s(e.formatSeconds(e.answer.doTime)))])])]),t("el-main",[t("el-form",{directives:[{name:"loading",rawName:"v-loading",value:e.formLoading,expression:"formLoading"}],ref:"form",attrs:{model:e.form,"label-width":"100px"}},[e._l(e.form.titleItems,(function(n,s){return t("el-row",{key:s},[t("h3",[e._v(e._s(n.name))]),0!==n.questionItems.length?t("el-card",{staticClass:"exampaper-item-box"},e._l(n.questionItems,(function(n){return t("el-form-item",{key:n.itemOrder,staticClass:"exam-question-item",attrs:{label:n.itemOrder+".","label-width":"50px",id:"question-"+n.itemOrder}},[t("el-row",[t("QuestionAnswerShow",{attrs:{qType:n.questionType,question:n,answer:e.answer.answerItems[n.itemOrder-1]}})],1),null===e.answer.answerItems[n.itemOrder-1].doRight?t("el-row",[t("label",{staticStyle:{color:"#e6a23c"}},[e._v("批改：")]),t("el-radio-group",{model:{value:e.answer.answerItems[n.itemOrder-1].score,callback:function(t){e.$set(e.answer.answerItems[n.itemOrder-1],"score",t)},expression:"answer.answerItems[questionItem.itemOrder-1].score"}},e._l(e.scoreSelect(n.score),(function(n){return t("el-radio",{key:n,attrs:{label:n}},[e._v(" "+e._s(n)+" ")])})),1)],1):e._e()],1)})),1):e._e()],1)})),t("el-row",{staticClass:"do-align-center"},[t("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("提交")]),t("el-button",[e._v("取消")])],1)],2)],1)],1)],1)},i=[],a=n("5530"),r=(n("14d9"),n("d3b7"),n("25f0"),n("2f62")),o=n("ed08"),c=n("ff3e"),l=n("ed24"),u={components:{QuestionAnswerShow:c["a"]},data:function(){return{form:{},formLoading:!1,answer:{id:null,score:0,doTime:0,answerItems:[],doRight:!1}}},created:function(){var e=this.$route.query.id,t=this;e&&0!==parseInt(e)&&(t.formLoading=!0,l["a"].read(e).then((function(e){t.form=e.response.paper,t.answer=e.response.answer,t.formLoading=!1})))},methods:{submitForm:function(){var e=this;e.formLoading=!0,l["a"].edit(this.answer).then((function(t){1===t.code?e.$alert("试卷得分："+t.response+"分","考试结果",{confirmButtonText:"返回考试记录",callback:function(t){e.$router.push("/record/index")}}):e.$message.error(t.message),e.formLoading=!1})).catch((function(t){e.formLoading=!1}))},scoreSelect:function(e){for(var t=[],n=0;n<=parseInt(e);n++)t.push(n.toString());return-1!==e.indexOf(".")&&t.push(e),t},formatSeconds:function(e){return Object(o["a"])(e)},questionDoRightTag:function(e){return this.enumFormat(this.doRightTag,e)},goAnchor:function(e){this.$el.querySelector(e).scrollIntoView({behavior:"instant",block:"center",inline:"nearest"})}},computed:Object(a["a"])(Object(a["a"])({},Object(r["c"])("enumItem",["enumFormat"])),Object(r["e"])("enumItem",{doRightTag:function(e){return e.exam.question.answer.doRightTag}}))},d=u,m=(n("ab07"),n("2877")),p=Object(m["a"])(d,s,i,!1,null,"1e9320d3",null);t["default"]=p.exports},ff3e:function(e,t,n){"use strict";var s=function(){var e=this,t=e._self._c;return t("div",{directives:[{name:"loading",rawName:"v-loading",value:e.qLoading,expression:"qLoading"}],staticStyle:{"line-height":"1.8"}},[1==e.qType||2==e.qType||3==e.qType||4==e.qType||5==e.qType?t("div",[1==e.qType?t("div",[t("div",{staticClass:"q-title",domProps:{innerHTML:e._s(e.question.title)}}),t("div",{staticClass:"q-content"},[t("el-radio-group",{model:{value:e.answer.content,callback:function(t){e.$set(e.answer,"content",t)},expression:"answer.content"}},e._l(e.question.items,(function(n){return t("el-radio",{key:n.prefix,attrs:{label:n.prefix}},[t("span",{staticClass:"question-prefix"},[e._v(e._s(n.prefix)+".")]),t("span",{staticClass:"q-item-span-content",domProps:{innerHTML:e._s(n.content)}})])})),1)],1)]):2==e.qType?t("div",[t("div",{staticClass:"q-title",domProps:{innerHTML:e._s(e.question.title)}}),t("div",{staticClass:"q-content"},[t("el-checkbox-group",{model:{value:e.answer.contentArray,callback:function(t){e.$set(e.answer,"contentArray",t)},expression:"answer.contentArray"}},e._l(e.question.items,(function(n){return t("el-checkbox",{key:n.prefix,attrs:{label:n.prefix}},[t("span",{staticClass:"question-prefix"},[e._v(e._s(n.prefix)+".")]),t("span",{staticClass:"q-item-span-content",domProps:{innerHTML:e._s(n.content)}})])})),1)],1)]):3==e.qType?t("div",[t("div",{staticClass:"q-title",staticStyle:{display:"inline","margin-right":"10px"},domProps:{innerHTML:e._s(e.question.title)}}),t("span",{staticStyle:{"padding-right":"10px"}},[e._v("(")]),t("el-radio-group",{model:{value:e.answer.content,callback:function(t){e.$set(e.answer,"content",t)},expression:"answer.content"}},e._l(e.question.items,(function(n){return t("el-radio",{key:n.prefix,attrs:{label:n.prefix}},[t("span",{staticClass:"q-item-span-content",domProps:{innerHTML:e._s(n.content)}})])})),1),t("span",{staticStyle:{"padding-left":"10px"}},[e._v(")")])],1):4==e.qType?t("div",[t("div",{staticClass:"q-title",domProps:{innerHTML:e._s(e.question.title)}}),null!==e.answer.contentArray?t("div",e._l(e.question.items,(function(n){return t("el-form-item",{key:n.prefix,staticStyle:{"margin-top":"10px","margin-bottom":"10px"},attrs:{label:n.prefix,"label-width":"50px"}},[t("el-input",{model:{value:e.answer.contentArray[n.prefix-1],callback:function(t){e.$set(e.answer.contentArray,n.prefix-1,t)},expression:"answer.contentArray[item.prefix-1]"}})],1)})),1):e._e()]):5==e.qType?t("div",[t("div",{staticClass:"q-title",domProps:{innerHTML:e._s(e.question.title)}}),t("div",[t("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:e.answer.content,callback:function(t){e.$set(e.answer,"content",t)},expression:"answer.content"}})],1)]):e._e(),t("div",{staticClass:"question-answer-show-item",staticStyle:{"margin-top":"15px"}},[t("span",{staticClass:"question-show-item"},[e._v("结果：")]),t("el-tag",{attrs:{type:e.doRightTagFormatter(e.answer.doRight)}},[e._v(" "+e._s(e.doRightTextFormatter(e.answer.doRight))+" ")])],1),t("div",{staticClass:"question-answer-show-item"},[t("span",{staticClass:"question-show-item"},[e._v("分数：")]),t("span",[e._v(e._s(e.question.score))])]),t("div",{staticClass:"question-answer-show-item"},[t("span",{staticClass:"question-show-item"},[e._v("难度：")]),t("el-rate",{staticClass:"question-show-item",attrs:{disabled:""},model:{value:e.question.difficult,callback:function(t){e.$set(e.question,"difficult",t)},expression:"question.difficult"}})],1),t("br"),t("div",{staticClass:"question-answer-show-item",staticStyle:{"line-height":"1.8"}},[t("span",{staticClass:"question-show-item"},[e._v("解析：")]),t("span",{staticClass:"q-item-span-content",domProps:{innerHTML:e._s(e.question.analyze)}})]),t("div",{staticClass:"question-answer-show-item"},[t("span",{staticClass:"question-show-item"},[e._v("正确答案：")]),1==e.qType||2==e.qType||5==e.qType?t("span",{staticClass:"q-item-span-content",domProps:{innerHTML:e._s(e.question.correct)}}):e._e(),3==e.qType?t("span",{staticClass:"q-item-span-content",domProps:{innerHTML:e._s(e.trueFalseFormatter(e.question))}}):e._e(),4==e.qType?t("span",[e._v(e._s(e.question.correctArray))]):e._e()])]):t("div")])},i=[],a=n("5530"),r=(n("a9e3"),n("4de4"),n("d3b7"),n("2f62")),o={name:"QuestionShow",props:{question:{type:Object,default:function(){return{}}},answer:{type:Object,default:function(){return{id:null,content:"",contentArray:[],doRight:!1}}},qLoading:{type:Boolean,default:!1},qType:{type:Number,default:0}},methods:{trueFalseFormatter:function(e){return e.items.filter((function(t){return t.prefix===e.correct}))[0].content},doRightTagFormatter:function(e){return this.enumFormat(this.doRightTag,e)},doRightTextFormatter:function(e){return this.enumFormat(this.doRightEnum,e)}},computed:Object(a["a"])(Object(a["a"])({},Object(r["c"])("enumItem",["enumFormat"])),Object(r["e"])("enumItem",{doRightEnum:function(e){return e.exam.question.answer.doRightEnum},doRightTag:function(e){return e.exam.question.answer.doRightTag}}))},c=o,l=n("2877"),u=Object(l["a"])(c,s,i,!1,null,null,null);t["a"]=u.exports}}]);