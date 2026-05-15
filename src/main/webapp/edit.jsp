<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .navbar-brand { font-weight: bold; }
        .card { border-radius: 10px; }
    </style>
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Hospital Management System</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Add Patient</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="view">View Patients</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow p-4">
                <h3 class="mb-4 text-warning text-center">Edit Patient</h3>
                
                <c:if test="${empty patient}">
                    <div class="alert alert-danger">Patient not found!</div>
                    <a href="view" class="btn btn-secondary">Back to List</a>
                </c:if>

                <c:if test="${not empty patient}">
                <form action="update" method="post" class="needs-validation" novalidate>
                    <input type="hidden" name="id" value="${patient.id}">
                    
                    <div class="mb-3">
                        <label class="form-label">Patient Name</label>
                        <input type="text" name="name" class="form-control" value="${patient.name}" required>
                        <div class="invalid-feedback">Please provide a valid name.</div>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Age</label>
                        <input type="number" name="age" class="form-control" value="${patient.age}" required min="0" max="150">
                        <div class="invalid-feedback">Please provide a valid age.</div>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Disease</label>
                        <input type="text" name="disease" class="form-control" value="${patient.disease}" required>
                        <div class="invalid-feedback">Please provide disease description.</div>
                    </div>
                    
                    <div class="d-flex justify-content-between mt-4">
                        <a href="view" class="btn btn-secondary">Cancel</a>
                        <button type="submit" class="btn btn-warning">Update Patient</button>
                    </div>
                </form>
                </c:if>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    (function () {
      'use strict'
      var forms = document.querySelectorAll('.needs-validation')
      Array.prototype.slice.call(forms)
        .forEach(function (form) {
          form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }
            form.classList.add('was-validated')
          }, false)
        })
    })()
</script>
</body>
</html>