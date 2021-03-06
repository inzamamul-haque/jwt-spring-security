# Spring Security and JWT Configuration

We will be configuring Spring Security and JWT for performing 2 operations-
Generating JWT - Expose a POST API with mapping /signIn. On passing correct username and password it will generate a JSON Web Token(JWT)
Validating JWT - If user tries to access GET API with mapping /hello. It will allow access only if request has a valid JSON Web Token(JWT).

## JwtAuthenticationEntryPoint

This class will extend Spring's AuthenticationEntryPoint class and override its method commence.
It rejects every unauthenticated request and send error code 401.

## JwtRequestFilter

The JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter class. For any incoming request this Filter class gets executed. It checks if the request has a valid JWT token.
If it has a valid JWT Token then it sets the Authentication in the context, to specify that the current user is authenticated.

## JwtTokenUtil

 The JwtTokenUtil is responsible for performing JWT operations like creation and validation.It makes use of the io.jsonwebtoken.
 Jwts for achieving this.
 
 ## UserDetailsServiceImpl
   
 UserDetailsServiceImpl implements the Spring Security UserDetailsService interface. It overrides the loadUserByUsername for fetching user details from the database using the username.
 The Spring Security Authentication Manager calls this method for getting the user details from the database when authenticating the user details provided by the user.
 
 ## WebSecurityConfig
 
 This class extends the WebSecurityConfigurerAdapter is a convenience class that allows customization to both WebSecurity and HttpSecurity.
 
