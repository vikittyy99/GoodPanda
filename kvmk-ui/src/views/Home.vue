<template>
  <div>

    <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="10000"
        controls
        indicators
        background-color="#2c3e50"
        img-width="1100"
        img-height="600"
        style="text-shadow: 1px 1px 2px #333;"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
          caption="Welcome"
          text=""
          img-src="https://livenewtab.com/wp-content/uploads/SearchFX2_5b229dafac40a9f608232bc8-e1534189919644.jpeg"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://i1.adis.ws/i/canon/canon-get-inspired-food-1-1920x1080-tint?qlt=80&w=100%&sm=aspect&aspect=16:9&fmt=jpg&fmt.options=interlaced&bg=rgb(255,255,255)">
        <h1>Find your recipes</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://wallpaperaccess.com/full/679975.jpg">

      </b-carousel-slide>

       <b-carousel-slide>
        <template #img>
          <img
              class="d-block img-fluid w-100"
              width="100"
              height="100"
              src="https://wallpaperaccess.com/full/462778.jpg"
              alt="image slot"
          >
        </template>
      </b-carousel-slide>

    </b-carousel>
    <h1>Hungry? You can find the best recipes here in GoodPanda!</h1>
     <p>
       People who love to eat are always the best people!
    </p>

    <div>
      <b-card-group columns>
        <b-card
            title="Spiced grains with peas, spinach and jammy eggs"
            img-src="https://images.immediate.co.uk/production/volatile/sites/2/2020/04/OLI-0420-Everyday_SpicedGrainsWithPeasJammyEggs_04185_preview-f604cb1.jpg?webp=true&quality=90&resize=620%2C413"
            img-alt="Image"
            img-top
        >
          <b-card-text>
            A riot of colour, this buttery freekeh dish is packed with spinach and peas,
            and flavoured with cumin, coriander and turmeric.
          </b-card-text>
        </b-card>

        <b-card header="Quote">
          <blockquote class="blockquote mb-0">

            <footer class="blockquote-footer">
               <cite title="Source Title">The food you eat can be either the safest
            & and most powerful form of medicine or the slowest form of poison</cite>
            </footer>
          </blockquote>
        </b-card>

        <b-card title="Cozy banana oatmeal muffins " img-src="https://www.acouplecooks.com/wp-content/uploads/2021/01/Banana-Oatmeal-Muffins-006.jpg" img-alt="Image" img-top>
          <b-card-text>
            "Every time you eat or drink, you are either feeding disease or fighting it."
          </b-card-text>
          <b-card-text class="small text-muted">Last updated 3 mins ago</b-card-text>
        </b-card>
        <b-card>
          <b-card-title>Eat Good.Feel Good.</b-card-title>
          <b-card-text>
            Try new foods.. Eat mindfully.. Listen to your body..
          </b-card-text>
          <b-card-text class="small text-muted">Last updated 3 mins ago</b-card-text>
        </b-card>

        <b-card img-src="https://www.acouplecooks.com/wp-content/uploads/2016/03/Easy-Vegetarian-Ramen-006.jpg" img-alt="Image" overlay></b-card>

        <b-card img-src="https://pinchofyum.com/wp-content/uploads/Chocolate-Chip-Cookies-400x400.jpg" img-alt="Image" img-top>
          <b-card-text>
           I'm just a person, standing in front of a salad, asking it to be a biscuit .. :(
          </b-card-text>
          <template #footer>
            <small class="text-muted">GoodPanda</small>
          </template>
        </b-card>
      </b-card-group>
    </div>

  </div>

</template>

<script>
export default {
  name: 'home',
  data() {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    }
  },
}
</script>
