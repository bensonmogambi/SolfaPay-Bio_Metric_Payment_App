<%-- 
    Document   : register
    Created on : Apr 23, 2015, 5:54:24 PM
    Author     : arjunmehrotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.css">
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <script src="http://cdn.rawgit.com/jquery/jquery-ui/1.10.4/ui/jquery.ui.datepicker.js"></script>
        <script id="mobile-datepicker" src="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.js"></script>
    </head>
    <body>
        <form type="input" action="RegisterServlet" method="Get">
            <div data-role="page">

                <div data-role="header" data-theme="b" data-position="fixed">
                    <h1>PayBM</h1>
                    <a href="index.jsp" data-icon="back" class="ui-btn-Left" rel="external">Back</a>
                </div><!-- /header -->

                <div role="main" class="ui-content ui-grid-b" data-theme="b" >

                    <div class="ui-grid-b ui-responsive">
                        <div class="ui-block-a">	
                            <label for="username">User Name:</label>
                            <input name="username" id="username" value="" type="text" placeholder="User Name" data-mini="true">

                            <label for="password">Password:</label>
                            <input name="password" id="password" value="" type="password" placeholder="Password" data-mini="true">

                            <label for="pin">Pin Number:</label>
                            <input name="pin" id="pin" value="" type="password" placeholder="Pin" data-mini="true">

                        </div>
                        <div class="ui-block-b">

                            <label for="firstname">First name:</label>
                            <input name="firstname" id="firstname" value="" type="text" placeholder="First name" data-mini="true">

                            <label for="lastname">Last Name:</label>
                            <input name="lastname" id="lastname" value="" type="text" placeholder="Last Name" data-mini="true">

                            <label for="dob">Date of Birth:</label>
                            <input name="dob" id="dob" data-role="date" type="text" placeholder="mm/dd/yyyy">

                            <label for="phonenumber">Phone Number:</label>
                            <input name="phonenumber" id="phonenumber" value="" type="text" placeholder="Phone name" data-mini="true">
                        </div>
                        <div class="ui-block-c">
                            <label for="address1">Address Line 1:</label>
                            <input name="address1" id="address1" value="" type="text" placeholder="Address Line 1" data-mini="true">

                            <label for="address2">Address Line 2:</label>
                            <input name="address2" id="address2" value="" type="text" placeholder="Address Line 2" data-mini="true">

                            <label for="address3">Address Line 3:</label>
                            <input name="address3" id="address3" value="" type="text" placeholder="Address Line 3" data-mini="true">

                            <label for="state" class="select">State</label>
                            <select name="state" id="state">
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

                            <label for="city">City:</label>
                            <input name="city" id="city" value="" type="text" placeholder="city" data-mini="true" >

                        </div>
                        <div class="ui-block-a">

                        </div>
                        <div class="ui-block-b">
                            <input type="submit" value="register">
                        </div>
                    </div>
                </div>
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
