<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/status"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
   uri="http://www.springframework.org/security/tags"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<page:template>
   <jsp:attribute name="title">
      Status Update
   </jsp:attribute>
   <jsp:body>
      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">
        
          <%-- Request status attribute: <%=request.getAttribute("statusUpdate") %><br/>
		  JSP Compiled Object: <%= this %><br/>
		  JSP Compiled Class: <%= this.getClass() %><br/> --%>
		  
          <!-- Title -->
          <h1 class="mt-4">Timeline</h1>

          <!-- Author -->
          <p class="lead">
            by
            <a href="#">Start Bootstrap</a>
          </p>
		  <p>Today's date January 1, 2018 at 12:00 PM</p>
          <hr>

          <!-- Comments Form -->
          <div class="card my-4">
            <h5 class="card-header">What's happening</h5>
            <div class="card-body">
              <form:form role="form"
                     action="${pageContext.request.contextPath}/saveStatusUpdate"
                     method="post" modelAttribute="statusUpdate">
     
					<div class="form-group">
						<form:textarea type="text"
                                 name="statusText" id="userName" path="statusText"
                                 class="form-control input-md" placeholder="What's happening?"
                                 tabindex="1" ></form:textarea>
					</div>
					<input class="btn btn-primary" type="submit" name="submit" value="Add Status" />				
			  </form:form>
            </div>
          </div>
          
          <hr>

		  <div class="card my-4">
		
			<div class="card-header">
				<div class="panel-title">Status update added on <fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s" value="${latestStatusUpdate.dateAdded}" /></div>
			</div>
			<div class="card-body">
				<c:out value="${latestStatusUpdate.statusText}" />
			</div>	
		  </div>
		  
          <hr>

          <!-- Comment with nested comments -->
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
            <div class="media-body">
              <h5 class="mt-0">Commenter Name</h5>
              <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>

              <div class="media mt-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                  <h5 class="mt-0">Commenter Name</h5>
                  <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
                </div>
              </div>
            </div>
          </div>

        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Search Widget -->
          <div class="card my-4">
            <h5 class="card-header">Search</h5>
            <div class="card-body">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="button">Go!</button>
                </span>
              </div>
            </div>
          </div>

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Trending</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">Web Design</a>
                    </li>
                    <li>
                      <a href="#">HTML</a>
                    </li>
                    <li>
                      <a href="#">Freebies</a>
                    </li>
                  </ul>
                </div>
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">JavaScript</a>
                    </li>
                    <li>
                      <a href="#">CSS</a>
                    </li>
                    <li>
                      <a href="#">Tutorials</a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">News</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div>

        </div>

      </div>
      <!-- /.row -->
      
   </jsp:body>
</page:template>