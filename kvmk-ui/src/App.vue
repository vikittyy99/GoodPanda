<template>
  <div id="app">
    <div id="nav">
      <b-nav tabs>
      <b-nav-item><router-link to="/"> Home </router-link> </b-nav-item>
      <b-nav-item><router-link to="/about"> About </router-link> </b-nav-item>

      <b-nav-item><router-link to="/Login"> Login </router-link> </b-nav-item>
      <b-nav-item><router-link to="/Register"> Register </router-link></b-nav-item>
        <b-nav-item><router-link to="/AddRecipe"> AddRecipe </router-link> </b-nav-item>
        <b-nav-item><router-link to="/Recipe"> Recipe </router-link> </b-nav-item>
      </b-nav>
    </div>
    <router-view/>

    <template>
      <!-- Footer -->
      <footer class="bg-light text-center text-lg-start">
        <!-- Grid container -->
        <div class="container p-4">
          <!--Grid row-->
          <div class="row">
            <!--Grid column-->
            <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
              <h5 class="text-uppercase">GoodPanda</h5>

              <p>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste atque ea quis
                molestias. Fugiat pariatur maxime quis culpa corporis vitae repudiandae aliquam
                voluptatem veniam, est atque cumque eum delectus sint!
              </p>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
              <h5 class="text-uppercase">SiteMap</h5>

              <ul class="list-unstyled mb-0">
                <li>
                  <a href="#!" class="text-dark">Home</a>
                </li>
                <li>
                  <a href="#!" class="text-dark">About us</a>
                </li>
                <li>
                  <a href="#!" class="text-dark">Recipes</a>
                </li>
                <li>
                  <a href="#!" class="text-dark">Help</a>
                </li>
              </ul>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
              <h5 class="text-uppercase mb-0">Contact us</h5>

              <ul class="list-unstyled">
                <li>
                  <a href="#!" class="text-dark">+359 2 165 876</a>
                </li>
                <li>
                  <a href="#!" class="text-dark">vmy@gmail.com</a>
                </li>
                <li>
                  <a href="#!" class="text-dark">Somewhere in LA I am not sure where yet ;)</a>
                </li>
<!--                <li>
                  <a href="#!" class="text-dark">Link 4</a>
                </li>-->
              </ul>
            </div>
            <!--Grid column-->
          </div>
          <!--Grid row-->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
          © 2021 Copyright:
          <a class="text-dark" href="https://GoodPanda/">GoodPanda.com All Rights Reserved</a>
        </div>
        <!-- Copyright -->
      </footer>
      <!-- Footer -->
    </template>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #1d1d1d;
}

#nav {
  text-align: left;
  margin-top: 0;
  margin-bottom: 20px;
  margin-left: 0;
  margin-right: 0;
  padding: 0;
  background-color: #f8f8f8;
}

#nav a {
  font-weight: bold;
  color: #262626;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script>

</script>
