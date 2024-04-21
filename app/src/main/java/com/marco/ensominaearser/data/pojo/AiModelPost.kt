package com.marco.ensominaearser.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AiModelPost (
    var Age:String,
    @SerializedName("Sleep Duration")
    @Expose
    var sleepDuration:String ,
    @SerializedName("Quality of Sleep")
    @Expose
    var qualityOfSleep : String ,
    @SerializedName("Physical Activity Level")
    @Expose
    var activityLevel : String ,
    @SerializedName("Stress Level")
    @Expose
    var stressLevel : String ,
    @SerializedName("BMI Category")
    @Expose
    var bmi : String ,
    @SerializedName("Heart Rate")
    @Expose
    var heartRate : String ,
    @SerializedName("Daily Steps")
    @Expose
    var dailySteps : String



 )