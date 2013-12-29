<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 
<t:simple_layout title="My page">
 
<jsp:attribute name="head_area">
  <script>
    function hello() {
        alert("Hello World");
    }
  </script>
</jsp:attribute>
 
<jsp:attribute name="body_area">
  <div>
    <button onclick="hello();">Hello There</button>
  </div>
</jsp:attribute>
 
</t:simple_layout>