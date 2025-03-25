import{D as U,E as S,G as x,B as b,J as R,K as T,b as a,I as y,$ as O,H as D,af as z,h as G,r as h,c as K,o as q,a as d,u as t,w as r,n as Q,s as W,ac as X,ad as Y,ab as k,i as Z}from"./index-yIIfo-1l.js";import{l as ee}from"./logo-as0tq7Ws.js";import{a as ae,b as oe}from"./auth-v1-top-shape-fXQX7UqL.js";import{a as te,V as m,S as g}from"./sweetalert2.esm.all-Cri9UH_p.js";import"./VAvatar-C73UamRc.js";import{V as w}from"./VImg-D1wMmKMc.js";import{V as le,d as se,a as C}from"./VCard-DUrcia-s.js";import{V as ne}from"./VForm-wLrojfDI.js";import{V as f}from"./VTextField-DcnueINI.js";import{V as I,m as re}from"./VSelectionControl-BWxlMuuN.js";import{u as ie,V as P,m as ue,a as de}from"./VInput-B5cU9eVz.js";/* empty css              */import"./_commonjsHelpers-CqkleIqs.js";import"./forwardRefs-D3j0TLhE.js";import"./index-B3Y5xi2I.js";const A=S({indeterminate:Boolean,indeterminateIcon:{type:O,default:"$checkboxIndeterminate"},...re({falseIcon:"$checkboxOff",trueIcon:"$checkboxOn"})},"VCheckboxBtn"),B=U()({name:"VCheckboxBtn",props:A(),emits:{"update:modelValue":o=>!0,"update:indeterminate":o=>!0},setup(o,p){let{slots:s}=p;const n=x(o,"indeterminate"),u=x(o,"modelValue");function i(l){n.value&&(n.value=!1)}const e=b(()=>n.value?o.indeterminateIcon:o.falseIcon),c=b(()=>n.value?o.indeterminateIcon:o.trueIcon);return R(()=>{const l=T(I.filterProps(o),["modelValue"]);return a(I,y(l,{modelValue:u.value,"onUpdate:modelValue":[V=>u.value=V,i],class:["v-checkbox-btn",o.class],style:o.style,type:"checkbox",falseIcon:e.value,trueIcon:c.value,"aria-checked":n.value?"mixed":void 0}),s)}),{}}}),me=S({...ue(),...T(A(),["inline"])},"VCheckbox"),ce=U()({name:"VCheckbox",inheritAttrs:!1,props:me(),emits:{"update:modelValue":o=>!0,"update:focused":o=>!0},setup(o,p){let{attrs:s,slots:n}=p;const u=x(o,"modelValue"),{isFocused:i,focus:e,blur:c}=ie(o),l=D(),V=b(()=>o.id||`checkbox-${l}`);return R(()=>{const[F,$]=z(s),M=P.filterProps(o),L=B.filterProps(o);return a(P,y({class:["v-checkbox",o.class]},F,M,{modelValue:u.value,"onUpdate:modelValue":v=>u.value=v,id:V.value,focused:i.value,style:o.style}),{...n,default:v=>{let{id:_,messagesId:j,isDisabled:N,isReadonly:E,isValid:H}=v;return a(B,y(L,{id:_.value,"aria-describedby":j.value,disabled:N.value,readonly:E.value},$,{error:H.value===!1,modelValue:u.value,"onUpdate:modelValue":J=>u.value=J,onFocus:e,onBlur:c}),n)}})}),{}}}),pe={class:"auth-wrapper d-flex align-center justify-center pa-4"},fe={class:"position-relative my-sm-16"},Ve=["innerHTML"],ve={class:"d-flex align-center my-6"},Ae={__name:"register",setup(o){const p=G(),s=h({username:"",email:"",password:"",confirmPassword:"",privacyPolicies:!1}),n=h(!1),u=()=>{Z.post("/api/v1/auth/register",s.value).then(i=>{console.log(i),g.fire({title:"Registration Successful!",text:"Redirecting to login...",icon:"success",timer:3e3,showConfirmButton:!1,allowOutsideClick:!1}),setTimeout(()=>{p.push("/login")},3e3)}).catch(i=>{var e;console.log(i),g.fire({title:"Registration Failed!",text:((e=i.response)==null?void 0:e.data)||"Something went wrong. Please try again.",icon:"error",confirmButtonText:"Try Again"})})};return(i,e)=>{const c=W("RouterLink");return q(),K("div",pe,[d("div",fe,[a(w,{src:t(ae),class:"text-primary auth-v1-top-shape d-none d-sm-block"},null,8,["src"]),a(w,{src:t(oe),class:"text-primary auth-v1-bottom-shape d-none d-sm-block"},null,8,["src"]),a(le,{class:Q(["auth-card",i.$vuetify.display.smAndUp?"pa-6":"pa-0"]),"max-width":"460"},{default:r(()=>[a(se,{class:"justify-center"},{default:r(()=>[a(c,{to:"/",class:"app-logo"},{default:r(()=>[d("div",{class:"d-flex",innerHTML:t(ee)},null,8,Ve),e[8]||(e[8]=d("h1",{class:"app-logo-title"}," Medicheck ",-1))]),_:1})]),_:1}),a(C,null,{default:r(()=>e[9]||(e[9]=[d("h4",{class:"text-h4 mb-1"}," Adventure starts here 🚀 ",-1),d("p",{class:"mb-0"}," Make your health management easy and fun! ",-1)])),_:1}),a(C,null,{default:r(()=>[a(ne,{onSubmit:X(u,["prevent"])},{default:r(()=>[a(te,null,{default:r(()=>[a(m,{cols:"12"},{default:r(()=>[a(f,{modelValue:t(s).name,"onUpdate:modelValue":e[0]||(e[0]=l=>t(s).name=l),autofocus:"",label:"Full Name",placeholder:"John doe"},null,8,["modelValue"])]),_:1}),a(m,{cols:"12"},{default:r(()=>[a(f,{modelValue:t(s).username,"onUpdate:modelValue":e[1]||(e[1]=l=>t(s).username=l),autofocus:"",label:"Username",placeholder:"Johndoe"},null,8,["modelValue"])]),_:1}),a(m,{cols:"12"},{default:r(()=>[a(f,{modelValue:t(s).email,"onUpdate:modelValue":e[2]||(e[2]=l=>t(s).email=l),label:"Email",type:"email",placeholder:"johndoe@email.com"},null,8,["modelValue"])]),_:1}),a(m,{cols:"12"},{default:r(()=>[a(f,{modelValue:t(s).password,"onUpdate:modelValue":e[3]||(e[3]=l=>t(s).password=l),label:"Password",autocomplete:"password",placeholder:"············",type:t(n)?"text":"password","append-inner-icon":t(n)?"bx-hide":"bx-show","onClick:appendInner":e[4]||(e[4]=l=>n.value=!t(n))},null,8,["modelValue","type","append-inner-icon"])]),_:1}),a(m,{cols:"12"},{default:r(()=>[a(f,{modelValue:t(s).confirmPassword,"onUpdate:modelValue":e[5]||(e[5]=l=>t(s).confirmPassword=l),label:"Confirm Password",autocomplete:"password",placeholder:"············",type:t(n)?"text":"password","append-inner-icon":t(n)?"bx-hide":"bx-show","onClick:appendInner":e[6]||(e[6]=l=>n.value=!t(n))},null,8,["modelValue","type","append-inner-icon"]),d("div",ve,[a(ce,{id:"privacy-policy",modelValue:t(s).privacyPolicies,"onUpdate:modelValue":e[7]||(e[7]=l=>t(s).privacyPolicies=l),inline:""},null,8,["modelValue"]),a(de,{for:"privacy-policy",style:{opacity:"1"}},{default:r(()=>e[10]||(e[10]=[d("span",{class:"me-1 text-high-emphasis"},"I agree to",-1),d("a",{href:"javascript:void(0)",class:"text-primary"},"privacy policy & terms",-1)])),_:1})]),a(Y,{block:"",type:"submit"},{default:r(()=>e[11]||(e[11]=[k(" Sign up ")])),_:1})]),_:1}),a(m,{cols:"12",class:"text-center text-base"},{default:r(()=>[e[13]||(e[13]=d("span",null,"Already have an account?",-1)),a(c,{class:"text-primary ms-1",to:"/login"},{default:r(()=>e[12]||(e[12]=[k(" Sign in instead ")])),_:1})]),_:1}),a(m,{cols:"12",class:"d-flex align-center"}),a(m,{cols:"12",class:"text-center"})]),_:1})]),_:1})]),_:1})]),_:1},8,["class"])])])}}};export{Ae as default};
