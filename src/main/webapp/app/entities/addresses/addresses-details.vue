<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="addresses">
        <h2 class="jh-entity-heading" data-cy="addressesDetailsHeading">
          <span v-text="$t('hermesvue1App.addresses.detail.title')">Addresses</span> {{ addresses.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('hermesvue1App.addresses.address')">Address</span>
          </dt>
          <dd>
            <span>{{ addresses.address }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.addressNo')">Address No</span>
          </dt>
          <dd>
            <span>{{ addresses.addressNo }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.zipCode')">Zip Code</span>
          </dt>
          <dd>
            <span>{{ addresses.zipCode }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.prosfLetter')">Prosf Letter</span>
          </dt>
          <dd>
            <span>{{ addresses.prosfLetter }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.nameLetter')">Name Letter</span>
          </dt>
          <dd>
            <span>{{ addresses.nameLetter }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.letterClose')">Letter Close</span>
          </dt>
          <dd>
            <span>{{ addresses.letterClose }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.firstLabel')">First Label</span>
          </dt>
          <dd>
            <span>{{ addresses.firstLabel }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.secondLabel')">Second Label</span>
          </dt>
          <dd>
            <span>{{ addresses.secondLabel }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.thirdLabel')">Third Label</span>
          </dt>
          <dd>
            <span>{{ addresses.thirdLabel }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.fourthLabel')">Fourth Label</span>
          </dt>
          <dd>
            <span>{{ addresses.fourthLabel }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.fifthLabel')">Fifth Label</span>
          </dt>
          <dd>
            <span>{{ addresses.fifthLabel }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.favourite')">Favourite</span>
          </dt>
          <dd>
            <span>{{ addresses.favourite }}</span>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.country')">Country</span>
          </dt>
          <dd>
            <div v-if="addresses.country">
              <router-link :to="{ name: 'CountriesView', params: { countriesId: addresses.country.id } }">{{
                addresses.country.name
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.kind')">Kind</span>
          </dt>
          <dd>
            <div v-if="addresses.kind">
              <router-link :to="{ name: 'ContactTypesView', params: { contactTypesId: addresses.kind.id } }">{{
                addresses.kind.name
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.region')">Region</span>
          </dt>
          <dd>
            <div v-if="addresses.region">
              <router-link :to="{ name: 'RegionsView', params: { regionsId: addresses.region.id } }">{{
                addresses.region.name
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.company')">Company</span>
          </dt>
          <dd>
            <div v-if="addresses.company">
              <router-link :to="{ name: 'CompaniesView', params: { companiesId: addresses.company.id } }">{{
                addresses.company.name
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('hermesvue1App.addresses.citizen')">Citizen</span>
          </dt>
          <dd>
            <div v-if="addresses.citizen">
              <router-link :to="{ name: 'CitizensView', params: { citizensId: addresses.citizen.id } }">{{
                addresses.citizen.id
              }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="addresses.id"
          :to="{ name: 'AddressesEdit', params: { addressesId: addresses.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./addresses-details.component.ts"></script>
