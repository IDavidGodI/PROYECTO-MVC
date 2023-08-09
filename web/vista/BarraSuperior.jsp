
<div class="container align-items-center mw-100 d-flex sticky-top justify-content-between bg-light">
        
    <% 
        String nombre = (String) request.getSession().getAttribute("nombre");
        String correo = (String) request.getSession().getAttribute("correo");
    %>
    
    <div class="row align-items-center flex-nowrap">

        <div class="col-md-2 p-2">

            <img src="https://lens-storage.storage.googleapis.com/png/b442569f35b445d3a48a58123c1d268e" 
             class="img-fluid" 
             alt="Responsive image"
            >
<!--            
            <img src="imagenes/PalomaSentá.png" 
             class="img-fluid" 
             alt="Responsive image"
            >-->
        </div>
        <div class="col" >   
            <h2 class="fw-bold fnt-1">PATRON-MVC</h2>
        </div>
    </div>
    <div class="row p-2 align-items-center flex-nowrap">

        <div class="col-md-auto">
            <i class="fa fa-user opacity-50 fa-4x"></i><br>
            
        </div>
        <div class="col-md-auto">
            <p class="h6"><%= nombre %></p>
            <p class="text-muted"><%= correo %></p>

        </div>
    </div>       
</div>

