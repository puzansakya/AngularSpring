<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Angular table example</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

        <script src="http://localhost:8080/testGround/static/js/app.js" type="text/javascript"></script>
    </head>
    <body ng-init="getAll()" ng-app="myApp" ng-controller="myController">
        <div class="container"> 
            <div class="row">
                <!--add form starts here-->
                <div class="col-md-5">
                    <!--trigger add modal here-->
                    <button class="btn btn-success" data-toggle="modal" data-target="#myAddModal" > Add new book.</button>
                </div>
            </div>
            <div class="row">              
                <div class="col-md-7">            
                    <hr>
                    <!--                    <button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal" data-target="#myModal">Add New</button>-->
                    <h2>Book list</h2>
                    <div class="clearfix"></div>
                    <hr>

                    <div class="alert alert-info alert-dismissible" role="alert" ng-if="info">
                        <button type="button" class="close" aria-label="Close"><span aria-hidden="true" ng-click="clearInfo()">&times;</span></button>
                        {{info}}
                    </div>

                    <!--search goes here-->
                    <label>Search </label><input type="text" class="form-control" ng-keyup="search(value)" ng-model="value"/>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Index</th>
                                <th>Book Id</th>
                                <th>Name</th>
                                <th>Author</th>
                                <th>Category Id</th>
                                <th>Category</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--ng-hide="book.name==='sdf'"-->
                            <tr ng-style="book.name === 'sdf' ? {'background': '#f2dede'} : {}" ng-repeat="book in books">
                                <td> {{ $index + 1}}.</td>
                                <td> {{book.bookId}} </td>
                                <td> {{book.name}} </td>
                                <td>{{book.author}}</td>
                                <td>{{book.category.categoryId}}</td>
                                <td>{{book.category.category}}</td>
                                <td> <button class="btn btn-info btn-sm"  type="button" data-toggle="modal" data-target="#myModalEdit" ng-click="selectBook(book)">Edit</button> </td>
                                <td> <button  class="btn btn-danger btn-sm" type="button"  ng-click="deleteBook(book)">Delete</button> </td>
                            </tr>		      
                        </tbody>
                    </table>
                </div>   
            </div>            
        </div>



        <!-- Trigger the modal with a button -->


        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add new Book.</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Username</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Username" ng-model="newUser.username">
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Email" ng-model="newUser.email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Full Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Full Name" ng-model="newUser.fullName">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="saveUser();">Save</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

        <!-- add modal goes here-->
        <div id="myAddModal" class="modal fade" role="dialog">
            <!-- Modal -->
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add book here.</h4>
                    </div>
                    <div class="modal-body">
                        <!--form starts here-->
                        <form id="book-form"  >
                            <div class="form-row">                            
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Book name" ng-model="formData.name">
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Author name" ng-model="formData.author">
                                </div>
                                <select ng-model="formData.category.categoryId" ng-model="formData.category.category">
                                    <option value="">select one</option>
                                    <c:forEach var="c" items="${categoryList}">
                                        <option value="${c.categoryId}">${c.category}</option>
                                    </c:forEach>
                                </select>
                            </div>                                               
                            <br>

                            <input type="submit" data-dismiss="modal" ng-click="saveBook();" class="btn btn-success btn-sm" value="submit">
                        </form>
                    </div>
                    <div class="modal-footer">                        	      	
                        <button type="button" class="btn btn-default pull-right" data-dismiss="modal">No</button>
                    </div>
                </div>

            </div>
        </div>
        <!--add modal ends here-->


        <!-- edit modal goes here -->
        <div id="myModalEdit" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Book</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <input type="hidden" value="{{clickedBook.bookId}}" ng-model="clickedBook.bookId">
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="name" placeholder="Book name" ng-model="clickedBook.name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="author" class="col-sm-2 control-label">Author</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="author" placeholder="Author" ng-model="clickedBook.author">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-success" data-dismiss="modal" ng-click="updateBook()">Update</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
        <!-- edit modal ends here-->



    </body>
</html>