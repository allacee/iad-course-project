import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { AuthLayoutComponent } from './shared/layouts/auth-layout/auth-layout.component';
import { SiteLayoutComponent } from './shared/layouts/site-layout/site-layout.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { GamesPageComponent } from './games-page/games-page.component';
import { MessagePageComponent } from './message-page/message-page.component';
import { GameFormComponent } from './games-page/game-form/game-form.component';
import { UserPageComponent } from './user-page/user-page.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { ReviewPageComponent } from './review-page/review-page.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { MessageNewComponent } from './message-new/message-new.component';
import { MessageOutComponent } from './message-out/message-out.component';
import { MessageInComponent } from './message-in/message-in.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    AuthLayoutComponent,
    SiteLayoutComponent,
    RegisterPageComponent,
    ProfilePageComponent,
    GamesPageComponent,
    MessagePageComponent,
    GameFormComponent,
    UserPageComponent,
    WelcomePageComponent,
    ReviewPageComponent,
    ErrorPageComponent,
    MessageNewComponent,
    MessageOutComponent,
    MessageInComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
