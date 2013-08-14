class BootStrap {

    def verticlesManagerService

    def init = { servletContext ->
        verticlesManagerService.loadVerticles()
    }
    def destroy = {
    }
}
