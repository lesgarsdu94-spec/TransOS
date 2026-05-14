dependencies {
    // --- Architecture & UI ---
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    
    // --- SIG & Cartographie (Mapbox v11) ---
    implementation("com.mapbox.maps:android:11.0.0")

    // --- DATA: Local (Room) ---
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // --- DATA: Remote (Retrofit & OkHttp) ---
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // --- Coroutines & Flow ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
