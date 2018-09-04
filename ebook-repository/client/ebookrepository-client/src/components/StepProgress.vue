<template>
  <section>
    <div class="container">
      <div class="steps-container">
        <div class="progressbar columns is-gapless">
          <div class="column" v-for="index in stepsRange" :key="index">
            <div>
              <div v-bind:class="['progress-indicator', {'is-activated-step': isActivatedStep(index)}]">
                <i class="fas fa-spinner" v-if="isActivatedStep(index) && !isDoneStep(index)"></i>
                <i class="fas fa-check" v-if="isDoneStep(index)"></i>
              </div>
              <div class="progress-step-label">{{stepLabels[index]}}</div>
            </div>
          </div>
        </div>
      </div>
      <div class="content">
          <component v-bind:is="currentForm"></component>
      </div>
      <div class="buttons-container level">
          <div class="level-left">
            <button 
              class="button is-light"
              @click="preparePreviousStep" 
              v-if="!isFirstStep">
              Back
            </button>
          </div>
          <div class="level-right">
            <button 
              class="button is-warning" 
              @click="prepareNextStep">
              Next
            </button>
          </div>
        </div>
      </div>
  </section>
</template>

<script>
export default {
  name: "StepProgress",
  props: ["total", "steps"],
  data() {
    return {
      currentStep: 0
    };
  },
  methods: {
    prepareNextStep() {
      this.currentConfig.onSubmit().then((data) => {
        if (this.currentStep < this.total - 1)
          ++this.currentStep;
        else {
          this.currentStep = 0;
        }
      });
    },
    preparePreviousStep() {
      this.currentConfig.onBack();
      --this.currentStep;
    },
    isActivatedStep(idx) {
      return idx <= this.currentStep;
    },
    isDoneStep(idx) {
      return idx < this.currentStep;
    }
  },
  computed: {
    currentConfig() {
      return this.steps[this.currentStep];
    },
    currentForm() {
      return this.steps[this.currentStep].component;
    },
    stepsRange() {
      return Array.from(Array(this.total).keys());
    },
    stepLabels() {
      return this.steps.map(step => step.label);
    },
    isFirstStep() {
      return this.currentStep === 0;
    },
  }
};
</script>

<style>
.container {
  text-align: center;
}

.steps-container {
  width: 100%;
}

.content {
  margin-top: 8%;
  margin-bottom: 8% !important;
  text-align: left;
}

.progress-indicator {
  width: 30px;
  height: 30px;
  display: block;
  margin: 0 auto 10px auto;
  border: 2px solid transparent;
  background: #ced4da;
  border-radius: 50%;
  line-height: 25px;
  color: #fff;
  text-align: center;
  font-family: "Font Awesome\ 5 Free";
  font-style: normal;
  font-weight: bold;
}

.progress-indicator:after {
  content: "";
  position: absolute;
  width: 50%;
  height: 3px;
  background: #ced4da;
  top: 15px;
  right: 24%;
  z-index: -1;
  align-self: right;
  z-index: 1;
}

.is-activated-step.progress-indicator:after {
  background: hsl(171, 100%, 41%);
}

.is-activated-step {
  background: hsl(171, 100%, 41%);
}

.steps-container {
  height: 100%;
}
</style>

