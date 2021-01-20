<template>
  <div id="app">
    <div id="nav">
      <b-nav tabs>
      <b-nav-item><router-link to="/"> Начало </router-link> </b-nav-item>
      <b-nav-item><router-link to="/about"> Блог </router-link> </b-nav-item>
        <b-nav-item><router-link to="/AddRecipe"> Добави рецепта </router-link> </b-nav-item>
        <b-nav-item><router-link to="/Recipe"> Рецепти </router-link> </b-nav-item>
        <b-nav-item><router-link to="/Login"> Вход </router-link> </b-nav-item>
        <b-nav-item><router-link to="/Register"> Регистрация </router-link></b-nav-item>
      </b-nav>
    </div>
    <router-view/>

    <template>
      <!-- Footer -->
      <footer class="bg-light text-center text-lg-start">
        <div class="container p-4">
          <div class="row">
            <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
              <h5 class="text-uppercase">GoodPanda</h5>

              <p>
                Ако се чудите какво вкусно ястие да си приготвите, GoodPanda е правилният избор!
                Тук ще намирите най-добрите рецепти от цял свят.Побързайте и се потопете в магията на готвенето.
              </p>
            </div>

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
              </ul>
            </div>
          </div>
        </div>

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
  background-color: #f5b47e;
}

#nav a {
  font-weight: bold;
  font-family: "Georgia";
  color: #262626;
}

#nav a.router-link-exact-active {
  color: #896856;
}
</style>

<script>

</script>
