<%-- 
    Document   : addPart
    Created on : 11.05.2018, 9:30:18
    Author     : banashko.dv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript">
            function validateForm() {
                var a=document.forms["FormAdd"]["pnumber"].value;
                var b=document.forms["FormAdd"]["pname"].value;
                var c=document.forms["FormAdd"]["vendor"].value;
                var d=document.forms["FormAdd"]["qty"].value;
                var e=document.forms["FormAdd"]["shipped"].value;
                var f=document.forms["FormAdd"]["received"].value;
                if (a==null || a=="",b==null || b=="",c==null || c=="",d==null || d=="",e==null || e=="", f==null || f=="") {
                    alert("Please fill all field");
                    return false;
                }
            }
        </script>    
        
        <h3>Add new part here</h3>
        
        <form name="FormAdd" method ="post" onsubmit="return validateForm()" action="/add/">
            <ul>
                <li>
                    <label>Part Number:
                        <input type="text" name="pnumber"><br />
                    </label>
                </li>

                <li>
                    <label>Part Name:
                        <input type="text" name="pname"><br />
                    </label>
                </li>

                <li>
                    <label>Vendor:
                        <input type="text" name="vendor" ><br />
                    </label>
                </li>

                <li>
                    <label>Quantity:
                        <input type="text" name="qty"><br />
                    </label>
                </li>
                
                <li>
                    <label>Shipped:
                        <input type="text" name="shipped"><br />
                    </label>
                </li>
                
                <li>
                    <label>Received:
                        <input type="text" name="received"><br />
                    </label>
                </li>

                <button type="submit">Submit</button>
            </ul>
              
        </form>
    </body>
</html>
