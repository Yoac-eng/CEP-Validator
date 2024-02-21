package br.com.conectaporto.validadorcep.models.dto;


/**
 * Classe criada para encapsular os dados retornados da api de consulta de
 * CEP do BrasilAberto.
 */
public class BrasilAbertoApiResponse {
    // Atributo que representa os meta dados da response
    private Meta meta;
    // Atributo que representa os resultados reais da response
    private Result result;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Meta {
        private int currentPage;
        private int itemsPerPage;
        private int totalOfItems;
        private int totalOfPages;

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getItemsPerPage() {
            return itemsPerPage;
        }

        public void setItemsPerPage(int itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
        }

        public int getTotalOfItems() {
            return totalOfItems;
        }

        public void setTotalOfItems(int totalOfItems) {
            this.totalOfItems = totalOfItems;
        }

        public int getTotalOfPages() {
            return totalOfPages;
        }

        public void setTotalOfPages(int totalOfPages) {
            this.totalOfPages = totalOfPages;
        }
    }

    public static class Result {
        private String street;
        private String complement;
        private String district;
        private int districtId;
        private String city;
        private int cityId;
        private int ibgeId;
        private String state;
        private String stateShortname;
        private String zipcode;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getComplement() {
            return complement;
        }

        public void setComplement(String complement) {
            this.complement = complement;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public int getDistrictId() {
            return districtId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getIbgeId() {
            return ibgeId;
        }

        public void setIbgeId(int ibgeId) {
            this.ibgeId = ibgeId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStateShortname() {
            return stateShortname;
        }

        public void setStateShortname(String stateShortname) {
            this.stateShortname = stateShortname;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
    }
}
