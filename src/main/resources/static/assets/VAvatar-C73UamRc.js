import{D as v,Z as h,br as C,C as S,bp as y,E as b,aA as p,aM as $,aN as P,aO as w,N as I,b8 as R,J as x,b as f,aR as V,U,W as D,b9 as E,X as z,aU as N,aV as A,$ as B,aX as F,V as J,a6 as L}from"./index-yIIfo-1l.js";import{g as O}from"./_commonjsHelpers-CqkleIqs.js";import{V as M}from"./VImg-D1wMmKMc.js";function W(n){let d=arguments.length>1&&arguments[1]!==void 0?arguments[1]:"div",s=arguments.length>2?arguments[2]:void 0;return v()({name:s??C(y(n.replace(/__/g,"-"))),props:{tag:{type:String,default:d},...h()},setup(r,a){let{slots:e}=a;return()=>{var t;return S(r.tag,{class:[n,r.class],style:r.style},(t=e.default)==null?void 0:t.call(e))}}})}var k={exports:{}};(function(n,d){(function(){var s={expires:"1d",path:"; path=/",domain:"",secure:"",sameSite:"; SameSite=Lax",partitioned:""},r={install:function(a,e){e&&this.config(e.expires,e.path,e.domain,e.secure,e.sameSite,e.partitioned);const t=a.config&&a.config.globalProperties;t&&(a.config.globalProperties.$cookies=this,a.provide&&a.provide("$cookies",this)),(!t||a.prototype)&&(a.prototype.$cookies=this),a.$cookies=this},config:function(a,e,t,c,i,u){s.expires=a||"1d",s.path=e?"; path="+e:"; path=/",s.domain=t?"; domain="+t:"",s.secure=c?"; Secure":"",s.sameSite=i?"; SameSite="+i:"; SameSite=Lax",s.partitioned=u?"; Partitioned":""},get:function(a){var e=decodeURIComponent(document.cookie.replace(new RegExp("(?:(?:^|.*;)\\s*"+encodeURIComponent(a).replace(/[\-\.\+\*]/g,"\\$&")+"\\s*\\=\\s*([^;]*).*$)|^.*$"),"$1"))||null;if(e&&(e.substring(0,1)==="{"&&e.substring(e.length-1,e.length)==="}"||e.substring(0,1)==="["&&e.substring(e.length-1,e.length)==="]"))try{e=JSON.parse(e)}catch{return e}return e},set:function(a,e,t,c,i,u,m,g){if(a){if(/^(?:expires|max\-age|path|domain|secure|SameSite)$/i.test(a))throw new Error('Cookie name illegality. Cannot be set to ["expires","max-age","path","domain","secure","SameSite"]	 current key name: '+a)}else throw new Error("Cookie name is not found in the first argument.");e&&typeof e=="object"&&(e=JSON.stringify(e));var o="";if(t=t===void 0?s.expires:t,t&&t!==0)switch(t.constructor){case Number:t===1/0||t===-1?o="; expires=Fri, 31 Dec 9999 23:59:59 GMT":o="; max-age="+t;break;case String:if(/^(?:\d+(y|m|d|h|min|s))$/i.test(t)){var l=t.replace(/^(\d+)(?:y|m|d|h|min|s)$/i,"$1");switch(t.replace(/^(?:\d+)(y|m|d|h|min|s)$/i,"$1").toLowerCase()){case"m":o="; max-age="+ +l*2592e3;break;case"d":o="; max-age="+ +l*86400;break;case"h":o="; max-age="+ +l*3600;break;case"min":o="; max-age="+ +l*60;break;case"s":o="; max-age="+l;break;case"y":o="; max-age="+ +l*31104e3;break}}else o="; expires="+t;break;case Date:o="; expires="+t.toUTCString();break}return document.cookie=encodeURIComponent(a)+"="+encodeURIComponent(e)+o+(i?"; domain="+i:s.domain)+(c?"; path="+c:s.path)+(u===void 0?s.secure:u?"; Secure":"")+(m===void 0?s.sameSite:m?"; SameSite="+m:"")+(g===void 0?s.partitioned:g?"; Partitioned":""),this},remove:function(a,e,t){return!a||!this.isKey(a)?!1:(document.cookie=encodeURIComponent(a)+"=; expires=Thu, 01 Jan 1970 00:00:00 GMT"+(t?"; domain="+t:s.domain)+(e?"; path="+e:s.path)+"; SameSite=Lax",!0)},isKey:function(a){return new RegExp("(?:^|;\\s*)"+encodeURIComponent(a).replace(/[\-\.\+\*]/g,"\\$&")+"\\s*\\=").test(document.cookie)},keys:function(){if(!document.cookie)return[];for(var a=document.cookie.replace(/((?:^|\s*;)[^\=]+)(?=;|$)|^\s*|\s*(?:\=[^;]*)?(?:\1|$)/g,"").split(/\s*(?:\=[^;]*)?;\s*/),e=0;e<a.length;e++)a[e]=decodeURIComponent(a[e]);return a}};n.exports=r,typeof window<"u"&&(window.$cookies=r)})()})(k);var j=k.exports;const Z=O(j),G=b({start:Boolean,end:Boolean,icon:B,image:String,text:String,...A(),...h(),...N(),...z(),...E(),...D(),...U(),...V({variant:"flat"})},"VAvatar"),q=v()({name:"VAvatar",props:G(),setup(n,d){let{slots:s}=d;const{themeClasses:r}=p(n),{borderClasses:a}=$(n),{colorClasses:e,colorStyles:t,variantClasses:c}=P(n),{densityClasses:i}=w(n),{roundedClasses:u}=I(n),{sizeClasses:m,sizeStyles:g}=R(n);return x(()=>f(n.tag,{class:["v-avatar",{"v-avatar--start":n.start,"v-avatar--end":n.end},r.value,a.value,e.value,i.value,u.value,m.value,c.value,n.class],style:[t.value,g.value,n.style]},{default:()=>[s.default?f(L,{key:"content-defaults",defaults:{VImg:{cover:!0,src:n.image},VIcon:{icon:n.icon}}},{default:()=>[s.default()]}):n.image?f(M,{key:"image",src:n.image,alt:"",cover:!0},null):n.icon?f(J,{key:"icon",icon:n.icon},null):n.text,F(!1,"v-avatar")]})),{}}});export{Z as C,q as V,W as c};
