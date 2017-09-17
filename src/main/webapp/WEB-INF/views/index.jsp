<%-- 
    Document   : index
    Created on : Sep 4, 2017, 6:26:47 PM
    Author     : puzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book index</title>
        <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous">
        </script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    </head>
    <body onload="getAll()" ng-app="myApp">

        <div ng-controller="myController"  class="row">
            <div class="col-md-2"></div>
            <div class="col-md-4">
                <!--form starts here-->
                <form id="book-form"  >
                    <div class="form-row">
                        <div class="col">
                            <input type="text" class="form-control" name="name" placeholder="Book name" ng-model="formData.name">
                        </div>
                        <div class="col">
                            <input type="text" class="form-control" name="author" placeholder="Author name" ng-model="formData.author">
                        </div>
                        <input type="hidden" name="category_id" id="category_id" ng-value="1" ng-model="formData.category_id">
                    </div>                                               
                    <br>

                    <input type="submit" ng-click="saveBook();" class="btn btn-success btn-sm" value="submit">
                </form>
                <br>


                <label>Enter key</label>    <button class="btn btn-success btn-sm" onclick="bindData(29)" data-toggle="modal" data-target="#myUpdate">Lunch modal</button>        
                <input type="text" class="form-control" onkeyup="search(this.value)"/>
                <br>
                <br>                    
            </div>              
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8" id="data"></div> 
            
        </div>



        <script>

            function getAll() {
                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url: "http://localhost:8080/testGround/getAll",
                    data: JSON.stringify(),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                        var head = "<table id=\"myTable\" class=\"table\">" +
                                "<tr>" +
                                "<th>name</th>" +
                                "<th>author</th>" +
                                "<th>Follow up</th>" +
                                "</tr>";
                        var row = "";
                        for (var i = 0; i < data.length; i++) {
                            row += '<tr><td>' + data[i].name + '</td><td>' + data[i].author + "</td><td>" + follow() + "</td>" + '</td><td>' +
                                    '<button class="btn btn-success btn-sm" onclick="bindData(' + data[i].bookId + ')" data-toggle="modal" data-target="#myUpdate">Lunch modal</button> ' +
                                    '<a href="http://localhost:8080/testGround/delete/' + data[i].bookId + '" class="btn btn-success btn-sm" >Delete</a> ' + '</td></tr>';
                        }

                        var foot = "</table>";
                        $("#data").html(head + row + foot);
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    }
                });
            }

            function follow() {
                return "5";
            }


            function search(key) {
                if (key.length == 0) {
                    getAll();
                }
                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url: "http://localhost:8080/testGround/search/" + key,
                    data: JSON.stringify(),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                        var head = "<table id=\"myTable\" class=\"table\">" +
                                "<tr>" +
                                "<th>name</th>" +
                                "<th>author</th>" +
                                "</tr>";
                        var row = "";
                        for (var i = 0; i < data.length; i++) {
                            row += '<tr><td>' + data[i].name + '</td><td>' + data[i].author + '</td><td><button>Edit</button></td></tr>';
                        }

                        var foot = "</table>";
                        $("#data").html(head + row + foot);
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    }
                });
            }
            function save() {
                $.post("http://localhost:8080/testGround/save", $("#book-form").serialize(), function (data) {
                    getAll();
                    $("#book-form")[0].reset();
                });
                return false;
            }
            function bindData(id) {
                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url: "http://localhost:8080/testGround/" + id,
                    data: JSON.stringify(),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {

                        $('#update-form').find('[name="name"]').val(data.name);
                        $('#update-form').find('[name="author"]').val(data.author);
                        $('#update_bookid').val(id);
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    }
                });
            }
        </script>


        <!-- Modal -->
        <div class="modal fade" id="myUpdate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">  
                        <form id="update-form" method="post" action="http://localhost:8080/testGround/update" >
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" class="form-control" name="name" id="update_name" placeholder="Book name">
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" name="author" id="update_author" placeholder="Author name">
                                </div>
                            </div>                           
                            <input type="hidden" name="category_id" id="category_id" value="1">
                            <input type="hidden" name="bookId" id="update_bookid">
                            <br>

                            <input type="submit" class="btn btn-success btn-sm" value="submit">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="http://localhost:8080/testGround/static/js/app.js" type="text/javascript"></script>
</html>
