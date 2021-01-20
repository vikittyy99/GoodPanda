 <template>
    <div class="container" style="align-items: center">
      <form class="well form-horizontal" action="" method="post" id="registration_form">
        <fieldset>
          <br/><br/><br/>
          <legend style="text-align: center; color: #262626; background-color: #f5b47e">Регистрация</legend>
          <div class="form-group" style="text-align: left">
            <label class="col-md-4 control-label" style="text-align: left;">Име</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input name="name" maxlength="30" v-model="name" placeholder="Name" class="form-control" type="text" onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" >
              </div>
            </div>
          </div>

          <div class="form-group" style="text-align: left">
            <label class="col-md-4 control-label" style="text-align: left; ">Емейл</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                <input name="email" maxlength="30" v-model="email" placeholder="E-Mail" class="form-control" type="text">
              </div>
            </div>
          </div>

          <div class="form-group" style="text-align: left">
            <label class="col-md-4 control-label" style="text-align: left; ">Парола</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input name="password" v-model="password" maxlength="16" placeholder="**********" class="form-control" type="password">
              </div>
            </div>
          </div>
          <div class="form-group" style="text-align: left">
            <label class="col-md-4 control-label" style="text-align: left; ">Потвърдете паролата си</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input name="confirmpassword" maxlength="16" v-model="confirmpassword" placeholder="**********" class="form-control" type="password">
              </div>
            </div>
          </div>
          <div class="img-fluid; column" style="float: right; top: -400px; position: relative; right: 500px; width:150px;">
            <img src="https://galaxypress.com/wp-content/uploads/2017/07/Chef_AS110485015.jpg" width="650px">
            <br style="clear: both;" />
          </div>
          <div class="alert alert-success" role="alert" style=" display: none;" id="registration_success">Registration Successfully Completed.</div>
          <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
              <button type="submit" v-on:click="register" class="btn btn-primary login-button" style="background-color: #f5b47e; color: #1d1d1d">регистрирай се</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </template>
<script>
import RecipeService from '../services/recipe-service'
export default {
  name: 'User',
  data () {
    return {
      name: '',
      email: '',
      password: '',
      confirmpassword: ''
    }
  },
  methods: {
    register (e) {
      e.preventDefault()
      const form = {
        name: this.name,
        email: this.email,
        password: this.password,
        confirmpassword: this.confirmpassword
      }
      RecipeService.register(form).then(
        response => {
          this.name = ''
          this.email = ''
          this.password = ''
          this.confirmpassword = ''
        })
    }
  }
}
</script>
