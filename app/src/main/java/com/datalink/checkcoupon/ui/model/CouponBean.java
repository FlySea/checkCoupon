package com.datalink.checkcoupon.ui.model;

import java.util.List;

public class CouponBean {
    /**
     * code : 200
     * data : {"current_page":1,"data":[{"id":1,"consumed_at":null,"normalize_exchangeable_name":"雨果测试改名","member":{"nickname":null,"mobile_phone":"18565801192"}}],"per_page":20}
     */

    private int code;
    private DataBeanX data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * current_page : 1
         * data : [{"id":1,"consumed_at":null,"normalize_exchangeable_name":"雨果测试改名","member":{"nickname":null,"mobile_phone":"18565801192"}}]
         * per_page : 20
         */

        private int current_page;
        private int per_page;
        private List<DataBean> data;

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1
             * consumed_at : null
             * normalize_exchangeable_name : 雨果测试改名
             * member : {"nickname":null,"mobile_phone":"18565801192"}
             */

            private int id;
            private String consumed_at;
            private String created_at;
            private String normalize_exchangeable_name;
            private MemberBean member;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getConsumed_at() {
                return consumed_at;
            }

            public void setConsumed_at(String consumed_at) {
                this.consumed_at = consumed_at;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = consumed_at;
            }

            public String getNormalize_exchangeable_name() {
                return normalize_exchangeable_name;
            }

            public void setNormalize_exchangeable_name(String normalize_exchangeable_name) {
                this.normalize_exchangeable_name = normalize_exchangeable_name;
            }

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public static class MemberBean {
                /**
                 * nickname : null
                 * mobile_phone : 18565801192
                 */

                private String nickname;
                private String mobile_phone;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getMobile_phone() {
                    return mobile_phone;
                }

                public void setMobile_phone(String mobile_phone) {
                    this.mobile_phone = mobile_phone;
                }
            }

        }
    }
}
