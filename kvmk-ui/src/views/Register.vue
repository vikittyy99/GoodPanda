
  <template>
    <div class="container">

      <form class="well form-horizontal" action="" method="post" id="registration_form">
        <fieldset>


          <legend>Register</legend>
          <div class="form-group">
            <label class="col-md-4 control-label">Name</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input name="name" maxlength="30" v-model="name" placeholder="Name" class="form-control" type="text" onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" >
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 control-label">E-Mail</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                <input name="email" maxlength="30" v-model="email" placeholder="E-Mail" class="form-control" type="text">
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 control-label">Password</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input name="password" v-model="password" maxlength="16" placeholder="**********" class="form-control" type="password">
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-4 control-label">Confirm Password</label>
            <div class="col-md-4 ">
              <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input name="confirmpassword" maxlength="16" v-model="confirmpassword" placeholder="**********" class="form-control" type="password">
              </div>
            </div>
          </div>

          <div class="alert alert-success" role="alert" style=" display: none;" id="registration_success">Registration Successfully Completed.</div>


          <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
              <button type="submit" v-on:click="register" class="btn btn-primary login-button">Register</button>
            </div>
          </div>

        </fieldset>
      </form>
    </div>
  </template>

  <script>
 /* import UsersService from "@/services/users-service";*/
 import RecipeService from '../services/recipe-service'

  export default {
    name: 'User',
    data () {
      return {
        name: "",
        email: "",
        password: "",
        confirmpassword: "",

      }
    },
    methods: {
      register(e){

        e.preventDefault()
        const form = {
          name: this.name,
          email: this.email,
          password: this.password,
          confirmpassword: this.confirmpassword,

        }
        RecipeService.register(form).then(
            response => {
              this.name = "";
              this.email = "";
              this.password = "";
              this.confirmpassword = "";
            },

        )
      }
    }
  }
  </script>