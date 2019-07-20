Vue.http.options.emulateJson = true;

new Vue({
    el: '#app',
    data() {
        return {
            checked: false,
            register: {
                username: '',
                password: '',
                repassword: ''
            }
        }
    },
    methods: {
        submitForm(register) {
            if (this.register.repassword != this.register.password) {
                this.$elmit(
                    'submit-form',
                    this.$message({
                        message: '两次输入的密码不一致！',
                        type: warning,
                        duration: 6000
                    })
                );
                this.$refs[register].resetFields();
            } else {
                this.$refs[register].validate((valid)) =
            >
                {
                    if (valid) {
                        this.$http.post('/register', {
                            username: this.register.username,
                            password: this.register.password
                        }).then(result = > {
                            console.log(result);
                        if (result.body.success) {
                            window.location.href = "/index";
                        } else {
                            this.$elmit(
                                'submit-form',
                                this.$message({
                                    message: result.body.message,
                                    type: warning,
                                    duration: 6000
                                })
                            );
                            this.$refs[register].resetFields();
                        }
                    });
                    } else {
                        this.$emit(
                            'submit-form',
                            this.$message({
                                message: '输入信息有误！',
                                type: warning,
                                duration: 6000
                            })
                        );
                        return false;

                    }
                }

            }
        },
        registerEnter(register) {
            this.submitForm(register);
        }
    }
})