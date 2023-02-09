<%-- 
    Document   : editProfile
    Created on : Apr 24, 2015, 12:13:58 AM
    Author     : arjunmehrotra
--%>

<%@page import="java.util.Calendar"%>
<%@page import="MDT.FingerPrint.cmu.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.css">
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <script src="http://cdn.rawgit.com/jquery/jquery-ui/1.10.4/ui/jquery.ui.datepicker.js"></script>
        <script id="mobile-datepicker" src="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.js"></script>
    </head>
    <body>
        <form type="input" action="UpdateProfileServlet" method="Get">
            <div data-role="page">
                <%Customer cust = (Customer) request.getAttribute("customer");%>
                <div data-role="header" data-theme="b" data-position="fixed">
                    <h1>PayBM</h1>
                    <a href="#nav-panel" data-icon="info" class="ui-btn-Left">Options</a>
                    <a href="#popupDialog" data-icon="power" data-rel="popup" data-position-to="window" data-transition="pop" class="ui-btn-Right">Logout</a>
                </div><!-- /header -->

                <div data-role="popup" id="popupDialog" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
                    <div data-role="header" data-theme="a">
                        <h1>Delete Page?</h1>
                    </div>
                    <div role="main" class="ui-content">
                        <h3 class="ui-title">Are you sure you want to Logout?</h3>
                        <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back">Cancel</a>
                        <a href="index.jsp" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" rel="external">Logout</a>
                    </div>
                </div>

                <div role="main" class="ui-content ui-grid-b" data-theme="b" >

                    <div class="ui-grid-b ui-responsive">
                        <div class="ui-block-a">	
                            <label for="username">User Name:</label>
                            <input name="username" id="username" value="<%=cust.getUsername()%>" disabled="disabled" type="text" data-mini="true">

                            <input name="username" id="username" value="<%=cust.getUsername()%>" hidden="true" type="text" data-mini="true">

                            <label for="password">Password:</label>
                            <input name="password" id="password" value="<%=cust.getPassword()%>" type="password" data-mini="true">
                            <!--<input name="password" id="password" value="<%=cust.getPassword()%>" type="password" hidden="true" data-mini="true">-->

                            <label for="pin">Pin Number:</label>
                            <input name="pin" id="pin" value="<%=cust.getPin()%>" type="password" placeholder="Pin" data-mini="true">

                        </div>
                        <div class="ui-block-b">

                            <label for="firstname">First name:</label>
                            <input name="firstname" id="firstname" value="<%=cust.getFirstName()%>" type="text" placeholder="First name" data-mini="true">

                            <label for="lastname">Last Name:</label>
                            <input name="lastname" id="lastname" value="<%=cust.getLastName()%>" type="text" placeholder="Last Name" data-mini="true">

                            <label for="dob">Date of Birth:</label>
                            <input data-role="date" name="dob" id="dob"  type="text" value="<%=cust.getDOB()%>">

                            <label for="phonenumber">Phone Number:</label>
                            <input name="phonenumber" id="phonenumber" value="<%=cust.getPhoneNumber()%>" type="text" placeholder="Phone name" data-mini="true">
                        </div>
                        <div class="ui-block-c">
                            <label for="address1">Address Line 1:</label>
                            <input name="address1" id="address1" value="<%=cust.getAddress()%>" type="text" placeholder="Address Line 1" data-mini="true">

                            <label for="address2">Address Line 2:</label>
                            <input name="address2" id="address2" value="<%=cust.getAddress2()%>" type="text" placeholder="Address Line 2" data-mini="true">

                            <label for="address3">Address Line 3:</label>
                            <input name="address3" id="address3" value="<%=cust.getAddress3()%>" type="text" placeholder="Address Line 3" data-mini="true">


                            <label for="state" class="select">State</label>
                            <select name="state" id="state" >
                                <option value="AL">Alabama</option>
                                <option value="AK">Alaska</option>
                                <option value="AZ">Arizona</option>
                                <option value="AR">Arkansas</option>
                                <option value="CA">California</option>
                                <option value="CO">Colorado</option>
                                <option value="CT">Connecticut</option>
                                <option value="DE">Delaware</option>
                                <option value="DC">District Of Columbia</option>
                                <option value="FL">Florida</option>
                                <option value="GA">Georgia</option>
                                <option value="HI">Hawaii</option>
                                <option value="ID">Idaho</option>
                                <option value="IL">Illinois</option>
                                <option value="IN">Indiana</option>
                                <option value="IA">Iowa</option>
                                <option value="KS">Kansas</option>
                                <option value="KY">Kentucky</option>
                                <option value="LA">Louisiana</option>
                                <option value="ME">Maine</option>
                                <option value="MD">Maryland</option>
                                <option value="MA">Massachusetts</option>
                                <option value="MI">Michigan</option>
                                <option value="MN">Minnesota</option>
                                <option value="MS">Mississippi</option>
                                <option value="MO">Missouri</option>
                                <option value="MT">Montana</option>
                                <option value="NE">Nebraska</option>
                                <option value="NV">Nevada</option>
                                <option value="NH">New Hampshire</option>
                                <option value="NJ">New Jersey</option>
                                <option value="NM">New Mexico</option>
                                <option value="NY">New York</option>
                                <option value="NC">North Carolina</option>
                                <option value="ND">North Dakota</option>
                                <option value="OH">Ohio</option>
                                <option value="OK">Oklahoma</option>
                                <option value="OR">Oregon</option>
                                <option value="PA">Pennsylvania</option>
                                <option value="RI">Rhode Island</option>
                                <option value="SC">South Carolina</option>
                                <option value="SD">South Dakota</option>
                                <option value="TN">Tennessee</option>
                                <option value="TX">Texas</option>
                                <option value="UT">Utah</option>
                                <option value="VT">Vermont</option>
                                <option value="VA">Virginia</option>
                                <option value="WA">Washington</option>
                                <option value="WV">West Virginia</option>
                                <option value="WI">Wisconsin</option>
                                <option value="WY">Wyoming</option>
                            </select>
                            <script>
                                function setSelectValue(id, val) {
                                    document.getElementById(id).value = val;
                                }
                                setSelectValue("state", "<%= cust.getState()%>");
                            </script>
                            <label for="city">City:</label>
                            <input name="city" id="city" value="<%=cust.getCity()%>" type="text" placeholder="city" data-mini="true" >

                        </div>
                        <div class="ui-block-a">

                        </div>
                        <div class="ui-block-b">
                            <input type="submit" value="Update Profile" rel="external">
                        </div>
                    </div>
                </div>
                <div data-role="panel" data-position-fixed="true" data-display="overlay" data-theme="b" id="nav-panel">
                    <ul data-role="listview">
                        <li data-icon="delete"><a href="#" data-rel="close">Close menu</a></li>
                        <li><a href="LoginServlet?username=<%=cust.getUsername()%>&password=<%=cust.getPassword()%>" rel="external">Home</a></li>
                        <li><a href="EditProfileServlet?username=<%=cust.getUsername()%>" rel="external">Edit Profile</a></li>
                        <li><a href="ManageCardServlet?username=<%=cust.getUsername()%>">Manage Cards</a></li>
                        <li><a href="ViewTransactionServlet?username=<%=cust.getUsername()%>">View Transactions</a></li>
                        <li><a href="Register1Servlet?username=<%=cust.getUsername()%>">Register Fingerprint</a></li>
                    </ul>
                </div><!-- /panel -->
                <div data-role="footer" data-position="fixed" data-theme="b">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="#" data-icon="comment">About</a></li>
                            <li><a href="#" data-icon="mail">Help</a></li>
                            <li><a href="#" data-icon="user">Careers</a></li>
                            <li><a href="#" data-icon="info">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div><!-- /footer -->
            </div><!-- /page --> 
        </form>
    </body>
</html>
