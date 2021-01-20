<template>
  <div>

    <b-card
        overlay
        img-src="https://i.imgur.com/451JbBK.png"
        img-alt="Card Image"
        text-variant="white"
    >
    </b-card>
    <br/>
    <h1><em><b>Седмични рецепти от всяка категория:</b></em></h1>
    <br/>
    <b-card-group columns>
      <router-link :to="{name: 'RecipeTab', params: {id: 47}}">
      <b-card
          title="Закуска"
          img-src="https://cdn.discordapp.com/attachments/777852160842137611/801245818932691014/unknown.png"
          img-alt="Image"
          img-top
      >
        <b-card-text>
          Посрещнете деня с усмивка и вкусни класически палачинки!
        </b-card-text>
      </b-card>
      </router-link>

      <router-link :to="{name: 'RecipeTab', params: {id: 49}}">
        <b-card title="Основно" img-src="https://cdn.discordapp.com/attachments/777852160842137611/801247806777458728/unknown.png"
                img-alt="Image"
                img-top>

          <b-card-text>
            Впечатлете всички гости с тази неустоима рецепта за телешки стек!
          </b-card-text>

        </b-card>
      </router-link>
        <router-link :to="{name: 'RecipeTab', params: {id: 50}}">
        <b-card
            title="Напитка"
            img-src="https://tmbidigitalassetsazure.blob.core.windows.net/rms3-prod/attachments/37/1200x1200/Chocolate-Peanut-Butter-Shakes_EXPS_FT19_245766_F_1008_1.jpg" img-alt="Image" img-top>
          <b-card-text>
            Топла напитка за студените дни, която да ви сгрее и обгърне със завладяващ аромат.

          </b-card-text>
        </b-card>
      </router-link>

      <router-link :to="{name: 'RecipeTab', params: {id: 48}}">
        <b-card
            title="Салата"

            img-src="https://cdn.discordapp.com/attachments/777852160842137611/801246894398373888/unknown.png"
            img-alt="Image"
            img-top
        >
          <b-card-text>

            Свежа и вкусна салата, подходяща за всяка трапеза!

          </b-card-text>
        </b-card>
      </router-link>

      <router-link :to="{name: 'RecipeTab', params: {id: 51}}">
        <b-card
            title="Десерт"
            img-src="https://www.glorioustreats.com/wp-content/uploads/2012/02/Layered-Desserts.jpg"
            img-alt="Image"
            img-top
        >
          <b-card-text>
            Безумно вкусна и леко пристрастяваща- какво повече да искаме от рецепта за десерт?
          </b-card-text>
        </b-card>
      </router-link>

      <router-link :to="{name: 'RecipeTab', params: {id: 52}}">
        <b-card
            title="Предястие"
            img-src="https://thebusybaker.ca/wp-content/uploads/2018/10/butternut-squash-soup-fb-ig3.jpg"
            img-alt="Image"
            img-top
        >
          <b-card-text>
            Крем супа, от която само една порция никога не е достатъчна!
          </b-card-text>
        </b-card>
      </router-link>
    </b-card-group>
  </div>
</template>
