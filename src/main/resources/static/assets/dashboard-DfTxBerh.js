import{h as m,r as f,c as h,o as n,a as u,b as c,w as s,i as g,ab as R,t as d,u as r,f as l,d as i}from"./index-yIIfo-1l.js";import{C as y}from"./VAvatar-C73UamRc.js";import{V as v}from"./VBanner-B28EgzET.js";import{V as k,a as p}from"./VCard-DUrcia-s.js";import"./_commonjsHelpers-CqkleIqs.js";import"./VImg-D1wMmKMc.js";const w={__name:"dashboard",setup(C){const e=m(),o=f({});return(()=>{e.currentRoute.value.path!="/register"&&e.currentRoute.value.path!="/forgotPassword"&&e.currentRoute.value.path!="/login"&&e.currentRoute.value.path!="/twoFactorVerify"&&(console.log("Checking User"),g.get("/api/v1/auth/checkUser",{headers:{"Content-Type":"application/json",Authorization:y.get("Authorization")}}).then(a=>{console.log(a),o.value=a.data}).catch(a=>{console.log(a),(a.response&&a.response.status===401||a.response.status===403)&&(console.log("Current Path : "+e.currentRoute.value.fullPath),e.currentRoute.value.path!="/register"&&e.currentRoute.value.path!="/forgotPassword"&&e.currentRoute.value.path!="/login"&&e.currentRoute.value.path!="/twoFactorVerify"&&e.push("/login"))}))})(),(a,t)=>(n(),h("div",null,[t[4]||(t[4]=u("p",{class:"text-2xl mb-6"}," Welcome Back , ",-1)),c(v,null,{default:s(()=>[R(d(r(o).name)+" ("+d(r(o).username)+") ",1)]),_:1}),c(k,null,{default:s(()=>[r(o).role=="ROLE_USER"&&r(o).attemptedDoctor==!0?(n(),l(p,{key:0},{default:s(()=>t[0]||(t[0]=[u("p",null,"Your Doctor Application Not Yet Accepted. You can send another Application to increase your Chances",-1)])),_:1})):i("",!0),r(o).role=="ROLE_USER"&&r(o).attemptedDoctor==!1?(n(),l(p,{key:1},{default:s(()=>t[1]||(t[1]=[u("p",null,"Get your Symptoms diagnosis here. You can get diagnosis from the machine learning system or you can speak to a doctor",-1)])),_:1})):i("",!0),r(o).role=="ROLE_DOCTOR"?(n(),l(p,{key:2},{default:s(()=>t[2]||(t[2]=[u("p",null,"Diagnise Symptoms for patients here",-1)])),_:1})):i("",!0),r(o).role=="ROLE_ADMIN"?(n(),l(p,{key:3},{default:s(()=>t[3]||(t[3]=[u("p",null,"You are the main Admin here. You can accept or reject doctors applications",-1)])),_:1})):i("",!0)]),_:1})]))}};export{w as default};
